package com.motokyi.tg.bot_api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.motokyi.tg.bot_api.api.ApiUrls;
import com.motokyi.tg.bot_api.api.methods.*;
import com.motokyi.tg.bot_api.config.properties.TelegramBotProperties;
import com.motokyi.tg.bot_api.exception.RequiredConfigMissedException;
import com.motokyi.tg.bot_api.exception.RequiredDataMissedException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClientUtils {

    public static void insertMethodParams(SendMethod<?> send, MultipartBodyBuilder builder) {
        if (StringUtils.isBlank(send.getChatId())) {
            throw new RequiredDataMissedException(SendMessage.CHAT_ID);
        }

        MultipartBodyUtils.insertString(SendMethod.CHAT_ID, send.getChatId(), builder);
        MultipartBodyUtils.insertString(SendMethod.PARSE_MODE, send.getParseMode(), builder);
        MultipartBodyUtils.insertObject(SendMethod.REPLY_TO_MESSAGE_ID, send.getReplyToMessageId(), builder);
        MultipartBodyUtils.insertObject(SendMethod.DISABLE_NOTIFICATION, send.getDisableNotification(), builder);
        MultipartBodyUtils.insertObject(SendMethod.DISABLE_WEB_PAGE_PREVIEW, send.getDisableWebPagePreview(), builder);
        if (nonNull(send.getReplyMarkup())) {
            try {
                MultipartBodyUtils.insertString(SendMethod.REPLY_MARKUP, send.getReplyMarkup().value(), builder);
            } catch (JsonProcessingException e) {
                log.error("Converting issue", e);
            }
        }
    }

    public static void insertMessageParams(SendMessage send, MultipartBodyBuilder builder) {

        insertMethodParams(send, builder);
        MultipartBodyUtils.insertString(SendMessage.TEXT, send.getText(), builder);
    }

    public static void insertAnimationParams(SendAnimation send, MultipartBodyBuilder builder) {

        insertMethodParams(send, builder);

        MultipartBodyUtils.insertString(SendAnimation.ANIMATION_ID, send.getAnimationId(), builder);
        MultipartBodyUtils.insertString(SendAnimation.THUMB_ID, send.getThumbId(), builder);
        MultipartBodyUtils.insertObject(SendAnimation.DURATION, send.getDuration(), builder);
        MultipartBodyUtils.insertObject(SendAnimation.WIDTH, send.getWidth(), builder);
        MultipartBodyUtils.insertObject(SendAnimation.HEIGHT, send.getHeight(), builder);
        MultipartBodyUtils.insertObject(SendAnimation.CAPTION, send.getCaption(), builder);
    }

    public static ExchangeFilterFunction logRequest(Logger logger) {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            final String[] urlFragments = request.url().getPath().split("/");
            logger.debug("HTTP: {} {}", request.method(), urlFragments[urlFragments.length - 1]);
            if (logger.isTraceEnabled()) {
                request.headers()
                        .forEach((name, values) -> values.forEach(value -> logger.trace("Request Header: {}={}", name, value)));
                request.attributes().forEach((key, value) -> logger.trace("Attr: {} {}", key, value));
            }
            return Mono.just(request);
        });
    }

    public static ExchangeFilterFunction logResponse(Logger logger) {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            logger.debug("HTTP: {}", response.statusCode());
            if (logger.isTraceEnabled()) {
                response.headers().asHttpHeaders()
                        .forEach((name, values) -> values.forEach(value -> logger.trace("Response Header: {}={}", name, value)));
            }
            return Mono.just(response);
        });
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendPhoto photo) {
        if (StringUtils.isNotBlank(photo.getPhotoId())) {
            return BodyInserters.fromValue(photo);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertMethodParams(photo, builder);
        builder.part(SendPhoto.PHOTO_ID, new FileSystemResource(photo.getPhotoFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendDocument document) {
        if (StringUtils.isNotBlank(document.getDocumentId())) {
            return BodyInserters.fromValue(document);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertMethodParams(document, builder);
        builder.part(SendDocument.DOCUMENT_ID, new FileSystemResource(document.getDocumentFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendAnimation animation) {
        if (StringUtils.isNotBlank(animation.getAnimationId())) {
            return BodyInserters.fromValue(animation);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertAnimationParams(animation, builder);
        builder.part(SendAnimation.ANIMATION_ID, new FileSystemResource(animation.getAnimationFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static <T, C> Function<ClientResponse, Mono<T>> responseHandler(final Class<C> cls,
                                                                           ParameterizedTypeReference<T> typeRef) {
        return responseHandler(cls.getName(), typeRef);
    }

    public static <T> Function<ClientResponse, Mono<T>> responseHandler(final String method,
                                                                        final ParameterizedTypeReference<T> typeRef) {
        return clientResponse -> {
            if (clientResponse.statusCode().isError()) {
                log.warn("Method {} got error {}", method, clientResponse.statusCode());
            }
            if (clientResponse.statusCode().is5xxServerError()) {
                log.warn("Attempt to recover after {}", clientResponse.statusCode());
                return Mono.empty();
            }
            return clientResponse.bodyToMono(typeRef);
        };
    }

    public static String createHostUrl(TelegramBotProperties properties) {
        if (isNull(properties) || !StringUtils.isNotBlank(properties.getToken())) {
            throw new RequiredConfigMissedException("Properties not correct. Token is empty or props is null.");
        }

        return (StringUtils.isNotBlank(properties.getApiHost()) ? properties.getApiHost() : ApiUrls.API_HOST)
                + ApiUrls.BOT_PREFIX
                + properties.getToken();
    }
}
