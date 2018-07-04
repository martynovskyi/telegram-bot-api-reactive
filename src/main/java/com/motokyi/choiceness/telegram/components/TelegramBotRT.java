package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.api.methods.SendDocument;
import com.motokyi.choiceness.telegram.api.methods.SendMessage;
import com.motokyi.choiceness.telegram.api.methods.SendMethod;
import com.motokyi.choiceness.telegram.api.methods.SendPhoto;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.Message;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.api.types.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotRT implements TelegramRT {

    private static final HttpHeaders multipartHeaders = new HttpHeaders(),
            bodyHeaders = new HttpHeaders(),
            jpgHeaders = new HttpHeaders(),
            pngHeaders = new HttpHeaders();
    private final RestTemplate rt;
    private final TelegramApiUrl url;

    {
        jpgHeaders.setContentType(MediaType.IMAGE_JPEG);
        pngHeaders.setContentType(MediaType.IMAGE_PNG);
        bodyHeaders.setContentType(MediaType.APPLICATION_JSON);
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
    }

    @Override
    public TLResponce<User> getMe() {
        return rt.exchange(
                url.getMe(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<TLResponce<User>>() {
                }).getBody();
    }

    @Override
    public TLResponce<Chat> getChat(Long chatId) {
        return rt.exchange(
                url.getChat(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<TLResponce<Chat>>() {
                },
                chatId).getBody();
    }

    @Override
    public TLResponce<Chat> getChat(String chatTag) {
        return rt.exchange(
                url.getChat(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<TLResponce<Chat>>() {
                },
                chatTag).getBody();
    }

    @Override
    public TLResponce<Message> sendMessage(Long chatId, String message) {
        return rt.exchange(
                url.getSendMessage(chatId, message),
                HttpMethod.POST,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    @Override
    public TLResponce<Message> sendMessage(SendMessage message) {
        return rt.exchange(
                url.getSendMessage(),
                HttpMethod.POST,
                new HttpEntity<>(message),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    @Override
    public TLResponce<Message> sendMessage(String chatTag, String message) {
        return rt.exchange(
                url.getSendMessage(chatTag, message),
                HttpMethod.POST,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    @Override
    public TLResponce<Message> sendPhoto(Long chatId, File image) {
        return rt.exchange(
                url.getSendPhoto(chatId),
                HttpMethod.POST,
                getMultipartFortDataBody(image, "photo"),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    @Override
    public TLResponce<Message> sendPhoto(SendPhoto photo) {
        if (photo.getPhotoId() != null) {
            return rt.exchange(
                    url.getSendPhoto(),
                    HttpMethod.POST,
                    new HttpEntity<>(photo, bodyHeaders),
                    new ParameterizedTypeReference<TLResponce<Message>>() {
                    }).getBody();
        }
        return rt.exchange(
                url.getSendPhoto(),
                HttpMethod.POST,
                getMultipartFortDataBody(photo.getPhotoFile(), photo, "photo"),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    public TLResponce<Message> sendDocument(Long chatId, File document) {
        return rt.exchange(
                url.getSendDocument(chatId),
                HttpMethod.POST,
                getMultipartFortDataBody(document, "document"),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    public TLResponce<Message> sendDocument(SendDocument document) {
        if (document.getDocumentId() != null) {
            return rt.exchange(
                    url.getSendDocument(),
                    HttpMethod.POST,
                    new HttpEntity<>(document, bodyHeaders),
                    new ParameterizedTypeReference<TLResponce<Message>>() {
                    }).getBody();
        }

        return rt.exchange(
                url.getSendDocument(),
                HttpMethod.POST,
                getMultipartFortDataBody(document.getDocumentFile(), document, "document"),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    @Override
    public void getUpdates() {
        ResponseEntity<String> result = rt.exchange(url.getUpdates(), HttpMethod.POST, HttpEntity.EMPTY, String.class);
        log.info(result.getBody());
    }

    private HttpEntity<MultiValueMap<String, Object>> getMultipartFortDataBody(File image, String partName) {
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add(partName, new FileSystemResource(image));
        return new HttpEntity<>(parts, multipartHeaders);
    }

    private HttpEntity<MultiValueMap<String, Object>> getMultipartFortDataBody(File image, SendMethod send, String partName) {
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();

        insertData(send, parts);
        parts.add(partName, new HttpEntity<>(new FileSystemResource(image), getHeadersByFile(image)));

        return new HttpEntity<>(parts, multipartHeaders);
    }

    private void insertData(SendMethod send, MultiValueMap<String, Object> parts) {
        if (StringUtils.isEmpty(send.getChatId())) {
            // TODO: 04.07.18 Exception flow
            throw new RuntimeException();
        }
        parts.add(SendMethod.CHAT_ID, send.getChatId());
        if (!StringUtils.isEmpty(send.getReplyToMessageId())) {
            parts.add(SendMethod.REPLY_TO_MESSAGE_ID, send.getReplyToMessageId());
        }
        if (!StringUtils.isEmpty(send.getDisableNotification())) {
            parts.add(SendMethod.DISABLE_NOTIFICATION, send.getDisableNotification());
        }
        if (!StringUtils.isEmpty(send.getDisableWebPagePreview())) {
            parts.add(SendMethod.DISABLE_WEB_PAGE_PREVIEW, send.getDisableWebPagePreview());
        }
        if (!StringUtils.isEmpty(send.getReplyMarkup())) {
            parts.add(SendMethod.REPLY_MARKUP, send.getReplyMarkup());
        }

    }

    private HttpHeaders getHeadersByFile(File file) {
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
