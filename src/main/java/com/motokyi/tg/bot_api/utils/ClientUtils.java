package com.motokyi.tg.bot_api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendAnimation;
import com.motokyi.tg.bot_api.api.method.payload.SendDocument;
import com.motokyi.tg.bot_api.api.method.payload.SendMethod;
import com.motokyi.tg.bot_api.api.method.payload.SendPhoto;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.exception.MissedBotConfigException;
import com.motokyi.tg.bot_api.exception.RequiredDataMissedException;
import com.motokyi.tg.bot_api.exception.TooManyRequestsException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ReactiveHttpOutputMessage;
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

    public static void insertMethodParams(SendMethod send, MultipartBodyBuilder builder) {
        if (StringUtils.isBlank(send.getChatId())) {
            throw new RequiredDataMissedException(ApiProperties.CHAT_ID);
        }

        MultipartBodyUtils.insertString(ApiProperties.CHAT_ID, send.getChatId(), builder);
        MultipartBodyUtils.insertString(ApiProperties.MESSAGE_THREAD_ID, send.getMessageThreadId(), builder);
        MultipartBodyUtils.insertString(ApiProperties.PARSE_MODE, send.getParseMode(), builder);
        MultipartBodyUtils.insertObject(ApiProperties.DISABLE_NOTIFICATION, send.getDisableNotification(), builder);
        MultipartBodyUtils.insertObject(ApiProperties.PROTECT_CONTENT, send.getProtectContent(), builder);
        MultipartBodyUtils.insertObject(ApiProperties.REPLY_PARAMETERS, send.getReplyParameters(), builder);
        if (nonNull(send.getReplyMarkup())) {
            try {
                MultipartBodyUtils.insertString(ApiProperties.REPLY_MARKUP, send.getReplyMarkup().value(), builder);
            } catch (JsonProcessingException e) {
                log.error("Converting issue", e);
            }
        }
    }

    public static void insertAnimationParams(SendAnimation send, MultipartBodyBuilder builder) {
        insertMethodParams(send, builder);
        MultipartBodyUtils.insertString(ApiProperties.ANIMATION, send.getAnimation(), builder);
        MultipartBodyUtils.insertString(ApiProperties.THUMBNAIL, send.getThumbnail(), builder);
        MultipartBodyUtils.insertObject(ApiProperties.DURATION, send.getDuration(), builder);
        MultipartBodyUtils.insertObject(ApiProperties.WIDTH, send.getWidth(), builder);
        MultipartBodyUtils.insertObject(ApiProperties.HEIGHT, send.getHeight(), builder);
        MultipartBodyUtils.insertObject(ApiProperties.CAPTION, send.getCaption(), builder);
    }

    public static ExchangeFilterFunction logRequest(Logger logger) {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            final String[] urlFragments = request.url().getPath().split("/");
            logger.debug("HTTP: {} {}", request.method(), urlFragments[urlFragments.length - 1]);
            if (logger.isTraceEnabled()) {
                request.headers()
                        .forEach((name, values) ->
                                values.forEach(value -> logger.trace("Request Header: {}={}", name, value)));
                request.attributes()
                        .forEach((key, value) -> logger.trace("Attr: {} {}", key, value));
            }
            return Mono.just(request);
        });
    }

    public static ExchangeFilterFunction logResponse(Logger logger) {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            logger.debug("HTTP: {} | Content Length {}", response.statusCode(), response.headers().contentLength());
            if (logger.isTraceEnabled()) {
                response.headers()
                        .asHttpHeaders()
                        .forEach((header, values) ->
                                values.forEach(value -> logger.trace("Response Header: {}={}", header, value)));
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
        if (StringUtils.isNotBlank(animation.getAnimation())) {
            return BodyInserters.fromValue(animation);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertAnimationParams(animation, builder);
        builder.part(ApiProperties.ANIMATION, new FileSystemResource(animation.getAnimationFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static <T, C> Function<ClientResponse, Mono<T>> responseHandler(final Class<C> cls,
                                                                           ParameterizedTypeReference<T> typeRef) {
        return responseHandler(cls.getSimpleName(), typeRef);
    }

    public static <T> Function<ClientResponse, Mono<T>> responseHandler(final String method,
                                                                        final ParameterizedTypeReference<T> typeRef) {
        return clientResponse -> {
            if (clientResponse.statusCode().isError()) {
                // Todo: create config option to transform to all error responses to Mono.error /
                // e.g. error-transformation-mode: ERROR | BODY

                log.warn("Method {} got error {}", method, clientResponse.statusCode());

                if (clientResponse.statusCode().is5xxServerError()) {
                    log.warn("Attempt to recover after {}", clientResponse.statusCode());
                    return Mono.empty();
                }

                if (clientResponse.statusCode().isSameCodeAs(HttpStatus.TOO_MANY_REQUESTS)) {
                    log.warn("Transform response to error after {}", clientResponse.statusCode());
                    return clientResponse.
                            bodyToMono(new ParameterizedTypeReference<Response<Void>>() {
                            })
                            .flatMap(r -> Mono.error(new TooManyRequestsException(r)));
                }
            }
            return clientResponse.bodyToMono(typeRef);
        };
    }

    public static String createBotUrl(BotConfigProperty properties) {
        if (isNull(properties) || !properties.isValid()) {
            throw new MissedBotConfigException("Properties not correct. Token is empty or props is null.");
        }

        return (StringUtils.isNotBlank(properties.getApiHost()) ? properties.getApiHost() : ApiUrls.API_HOST)
               + ApiUrls.BOT_PREFIX
               + properties.getToken();
    }
}
