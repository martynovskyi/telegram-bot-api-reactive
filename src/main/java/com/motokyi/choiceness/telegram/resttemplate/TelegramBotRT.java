package com.motokyi.choiceness.telegram.resttemplate;

import com.motokyi.choiceness.telegram.api.methods.*;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.Message;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.api.types.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

import static com.motokyi.choiceness.telegram.resttemplate.TGRTUtils.*;

@Slf4j
@RequiredArgsConstructor
public class TelegramBotRT implements TelegramRT {

    private final RestTemplate rt;
    private final TelegramApiUrl url;

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
    public void getUpdates() {
        ResponseEntity<String> result = rt.exchange(url.getUpdates(), HttpMethod.POST, HttpEntity.EMPTY, String.class);
        log.info(result.getBody());
    }

    @Override
    public TLResponce<Message> send(SendMessage message) {
        return rt.exchange(
                url.getSendMessage(),
                HttpMethod.POST,
                new HttpEntity<>(message),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    @Override
    public TLResponce<Message> send(SendPhoto photo) {
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
                createHttpEntity(photo.getPhotoFile(), photo, "photo"),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    public TLResponce<Message> send(SendDocument document) {
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
                createHttpEntity(document.getDocumentFile(), document, "document"),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    public TLResponce<Message> send(SendAnimation animation) {
        if (animation.getAnimationId() != null) {
            return rt.exchange(
                    url.getSendDocument(),
                    HttpMethod.POST,
                    new HttpEntity<>(animation, bodyHeaders),
                    new ParameterizedTypeReference<TLResponce<Message>>() {
                    }).getBody();
        }

        return rt.exchange(
                url.getSendDocument(),
                HttpMethod.POST,
                createHttpEntity(animation.getAnimationFile(), animation, "animation"),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    private HttpEntity<MultiValueMap<String, Object>> createHttpEntity(File image, SendMethod send, String partName) {
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();

        insertData(send, parts);
        parts.add(partName, new HttpEntity<>(new FileSystemResource(image), getHeadersByFile(image)));

        return new HttpEntity<>(parts, multipartHeaders);
    }

}
