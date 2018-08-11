package com.motokyi.choiceness.telegram.resttemplate;

import com.motokyi.choiceness.telegram.api.methods.SendMethod;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.File;

public final class TGRTUtils {

    public static final HttpHeaders multipartHeaders = new HttpHeaders(),
            bodyHeaders = new HttpHeaders(),
            jpgHeaders = new HttpHeaders(),
            pngHeaders = new HttpHeaders();

    static {
        jpgHeaders.setContentType(MediaType.IMAGE_JPEG);
        pngHeaders.setContentType(MediaType.IMAGE_PNG);
        bodyHeaders.setContentType(MediaType.APPLICATION_JSON);
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
    }

    public static void insertData(SendMethod send, MultiValueMap<String, Object> parts) {
        if (StringUtils.isEmpty(send.getChatId())) {
            // TODO: 04.07.18 Exception flow
            throw new RuntimeException();
        }

        addChatId(send, parts);

        addReplyMessageId(send, parts);

        addDisableNotification(send, parts);

        addDisableWebPagePreview(send, parts);

        addReplyMarkup(send, parts);

    }

    public static void addChatId(SendMethod send, MultiValueMap<String, Object> parts) {
        if (!StringUtils.isEmpty(send.getChatId())) {
            parts.add(SendMethod.REPLY_MARKUP, send.getChatId());
        }
    }

    public static void addReplyMarkup(SendMethod send, MultiValueMap<String, Object> parts) {
        if (!StringUtils.isEmpty(send.getReplyMarkup())) {
            parts.add(SendMethod.REPLY_MARKUP, send.getReplyMarkup());
        }
    }

    public static void addDisableWebPagePreview(SendMethod send, MultiValueMap<String, Object> parts) {
        if (!StringUtils.isEmpty(send.getDisableWebPagePreview())) {
            parts.add(SendMethod.DISABLE_WEB_PAGE_PREVIEW, send.getDisableWebPagePreview());
        }
    }

    public static void addDisableNotification(SendMethod send, MultiValueMap<String, Object> parts) {
        if (!StringUtils.isEmpty(send.getDisableNotification())) {
            parts.add(SendMethod.DISABLE_NOTIFICATION, send.getDisableNotification());
        }
    }

    public static void addReplyMessageId(SendMethod send, MultiValueMap<String, Object> parts) {
        if (!StringUtils.isEmpty(send.getReplyToMessageId())) {
            parts.add(SendMethod.REPLY_TO_MESSAGE_ID, send.getReplyToMessageId());
        }
    }

    public static HttpHeaders getHeadersByFile(File file) {
        String extension = FilenameUtils.getExtension(file.getAbsolutePath());
        switch (extension.toLowerCase()) {
            case "jpg": {
                return jpgHeaders;
            }

            case "jpeg": {
                return jpgHeaders;
            }

            case "png": {
                return pngHeaders;
            }

            default: {
                // TODO: 04.07.18 Exception flow
                throw new RuntimeException();
            }
        }

    }
}
