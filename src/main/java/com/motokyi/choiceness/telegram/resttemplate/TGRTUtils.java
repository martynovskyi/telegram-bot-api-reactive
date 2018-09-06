package com.motokyi.choiceness.telegram.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.motokyi.choiceness.telegram.api.methods.SendAnimation;
import com.motokyi.choiceness.telegram.api.methods.SendMessage;
import com.motokyi.choiceness.telegram.api.methods.SendMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.File;

import static java.util.Objects.isNull;

@Slf4j
public final class TGRTUtils {

    public static final HttpHeaders multipartHeaders = new HttpHeaders(),
            bodyHeaders = new HttpHeaders(),
            jpgHeader = new HttpHeaders(),
            pngHeader = new HttpHeaders(),
            gifHeader = new HttpHeaders();

    static {
        jpgHeader.setContentType(MediaType.IMAGE_JPEG);
        pngHeader.setContentType(MediaType.IMAGE_PNG);
        gifHeader.setContentType(MediaType.IMAGE_GIF);
        bodyHeaders.setContentType(MediaType.APPLICATION_JSON);
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
    }

    public static void insertMethodParams(SendMethod send, MultiValueMap<String, Object> parts) {
        if (StringUtils.isEmpty(send.getChatId())) {
            // TODO: 04.07.18 Exception flow
            throw new RuntimeException();
        }

        insertString(SendMethod.CHAT_ID, send.getChatId(), parts);
        insertObject(SendMethod.REPLY_TO_MESSAGE_ID, send.getReplyToMessageId(), parts);
        insertObject(SendMethod.DISABLE_NOTIFICATION, send.getDisableNotification(), parts);
        insertObject(SendMethod.DISABLE_WEB_PAGE_PREVIEW, send.getDisableWebPagePreview(), parts);
        if (!isNull(send.getReplyMarkup())) {
            try {
                insertString(SendMethod.REPLY_MARKUP, send.getReplyMarkup().value(), parts);
            } catch (JsonProcessingException e) {
                log.error("Converting issue", e);
            }
        }
    }

    public static void insertMessageParams(SendMessage send, MultiValueMap<String, Object> parts) {

        insertMethodParams(send, parts);
        insertString(SendMessage.TEXT, send.getText(), parts);

    }

    public static void insertAnimationParams(SendAnimation send, MultiValueMap<String, Object> parts) {

        insertMethodParams(send, parts);

        insertString(SendAnimation.ANIMATION_ID, send.getAnimationId(), parts);
        insertString(SendAnimation.THUMB_ID, send.getThumbId(), parts);
        insertObject(SendAnimation.DURATION, send.getDuration(), parts);
        insertObject(SendAnimation.WIDTH, send.getWidth(), parts);
        insertObject(SendAnimation.HEIGHT, send.getHeight(), parts);
        insertObject(SendAnimation.CAPTION, send.getCaption(), parts);

    }

    public static void insertString(String key, String value, MultiValueMap<String, Object> parts) {
        if (StringUtils.hasText(value)) {
            parts.add(key, value);
        }
    }

    public static void insertObject(String key, Object value, MultiValueMap<String, Object> parts) {
        if (value != null) {
            parts.add(key, value);
        }
    }

    public static HttpHeaders getHeadersByFile(File file) {
        String extension = FilenameUtils.getExtension(file.getAbsolutePath());
        switch (extension.toLowerCase()) {
            case "jpg": {
                return jpgHeader;
            }

            case "jpeg": {
                return jpgHeader;
            }

            case "png": {
                return pngHeader;
            }

            case "gif": {
                return gifHeader;
            }

            default: {
                // TODO: 04.07.18 Exception flow
                throw new RuntimeException();
            }
        }

    }
}
