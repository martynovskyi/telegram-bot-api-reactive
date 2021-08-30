package com.motokyi.tg.botapi.webclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendDocument;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendMethod;
import com.motokyi.tg.botapi.api.methods.SendPhoto;
import com.motokyi.tg.botapi.exception.RequiredDataMissedException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
public final class ClientUtils {

    public static void insertMethodParams(SendMethod<?> send, MultipartBodyBuilder builder) {
        if (!StringUtils.hasText(send.getChatId())) {
            throw new RequiredDataMissedException(SendMessage.CHAT_ID);
        }

        insertString(SendMethod.CHAT_ID, send.getChatId(), builder);
        insertString(SendMethod.PARSE_MODE, send.getParseMode(), builder);
        insertObject(SendMethod.REPLY_TO_MESSAGE_ID, send.getReplyToMessageId(), builder);
        insertObject(SendMethod.DISABLE_NOTIFICATION, send.getDisableNotification(), builder);
        insertObject(SendMethod.DISABLE_WEB_PAGE_PREVIEW, send.getDisableWebPagePreview(), builder);
        if (nonNull(send.getReplyMarkup())) {
            try {
                insertString(SendMethod.REPLY_MARKUP, send.getReplyMarkup().value(), builder);
            } catch (JsonProcessingException e) {
                log.error("Converting issue", e);
            }
        }
    }

    public static void insertMessageParams(SendMessage send, MultipartBodyBuilder builder) {

        insertMethodParams(send, builder);
        insertString(SendMessage.TEXT, send.getText(), builder);
    }

    public static void insertAnimationParams(SendAnimation send, MultipartBodyBuilder builder) {

        insertMethodParams(send, builder);

        insertString(SendAnimation.ANIMATION_ID, send.getAnimationId(), builder);
        insertString(SendAnimation.THUMB_ID, send.getThumbId(), builder);
        insertObject(SendAnimation.DURATION, send.getDuration(), builder);
        insertObject(SendAnimation.WIDTH, send.getWidth(), builder);
        insertObject(SendAnimation.HEIGHT, send.getHeight(), builder);
        insertObject(SendAnimation.CAPTION, send.getCaption(), builder);
    }

    public static void insertString(String key, String value, MultipartBodyBuilder builder) {
        if (hasText(key) && hasText(value)) {
            builder.part(key, value);
        }
    }

    public static void insertObject(String key, Object value, MultipartBodyBuilder builder) {
        if (hasText(key) && nonNull(value)) {
            builder.part(key, value);
        }
    }

    public static ExchangeFilterFunction logRequest(Logger logger) {
        return (request, next) -> {
            logger.info("Request: {} {}", request.method(), request.url());
//            request.headers()
//                    .forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
            return next.exchange(request);
        };
    }

    public static ExchangeFilterFunction logResponse(Logger logger) {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            logger.info("Response Status {}", response.statusCode());
//            response.headers().asHttpHeaders()
//                    .forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
            return Mono.just(response);
        });
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendPhoto photo) {
        if (StringUtils.hasText(photo.getPhotoId())) {
            return BodyInserters.fromValue(photo);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertMethodParams(photo, builder);
        builder.part(SendPhoto.PHOTO_ID, new FileSystemResource(photo.getPhotoFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendDocument document) {
        if (StringUtils.hasText(document.getDocumentId())) {
            return BodyInserters.fromValue(document);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertMethodParams(document, builder);
        builder.part(SendDocument.DOCUMENT_ID, new FileSystemResource(document.getDocumentFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendAnimation animation) {
        if (StringUtils.hasText(animation.getAnimationId())) {
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
                log.warn("{} got error {}", method, clientResponse.statusCode());
            }
            return clientResponse.bodyToMono(typeRef);
        };
    }
}
