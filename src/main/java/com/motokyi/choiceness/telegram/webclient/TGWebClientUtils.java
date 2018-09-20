package com.motokyi.choiceness.telegram.webclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.motokyi.choiceness.telegram.api.methods.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
public final class TGWebClientUtils {

    public static void insertMethodParams(SendMethod send, MultipartBodyBuilder builder) {
        if (StringUtils.isEmpty(send.getChatId())) {
            // TODO: 04.07.18 Exception flow
            throw new RuntimeException();
        }

        insertString(SendMethod.CHAT_ID, send.getChatId(), builder);
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
        if (hasText(value) && hasText(value)) {
            builder.part(key, value);
        }
    }

    public static void insertObject(String key, Object value, MultipartBodyBuilder builder) {
        if (nonNull(value) && hasText(key)) {
            builder.part(key, value);
        }
    }

    public static ExchangeFilterFunction logRequest(Logger logger) {
        return (clientRequest, next) -> {
            logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }

    public static ExchangeFilterFunction logResponse(Logger logger) {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            logger.info("Response Status {}", clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendPhoto photo) {
        if (StringUtils.hasText(photo.getPhotoId())) {
            return BodyInserters.fromObject(photo);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertMethodParams(photo, builder);
        builder.part(SendPhoto.PHOTO_ID, new FileSystemResource(photo.getPhotoFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendDocument document) {
        if (StringUtils.hasText(document.getDocumentId())) {
            return BodyInserters.fromObject(document);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertMethodParams(document, builder);
        builder.part(SendDocument.DOCUMENT_ID, new FileSystemResource(document.getDocumentFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }

    public static BodyInserter<?, ? super ClientHttpRequest> createBody(SendAnimation animation) {
        if (StringUtils.hasText(animation.getAnimationId())) {
            return BodyInserters.fromObject(animation);
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        insertAnimationParams(animation, builder);
        builder.part(SendAnimation.ANIMATION_ID, new FileSystemResource(animation.getAnimationFile()));
        return BodyInserters.fromMultipartData(builder.build());
    }
}
