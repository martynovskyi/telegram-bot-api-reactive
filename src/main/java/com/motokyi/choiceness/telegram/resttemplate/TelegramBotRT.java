package com.motokyi.choiceness.telegram.resttemplate;

import com.motokyi.choiceness.telegram.api.methods.SendAnimation;
import com.motokyi.choiceness.telegram.api.methods.SendDocument;
import com.motokyi.choiceness.telegram.api.methods.SendMessage;
import com.motokyi.choiceness.telegram.api.methods.SendPhoto;
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
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

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
                new HttpEntity<>(message, bodyHeaders),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    @Override
    public TLResponce<Message> send(SendPhoto photo) {
        return rt.exchange(
                url.getSendPhoto(),
                HttpMethod.POST,
                createHttpEntity(photo),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    public TLResponce<Message> send(SendDocument document) {
        return rt.exchange(
                url.getSendDocument(),
                HttpMethod.POST,
                createHttpEntity(document),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    public TLResponce<Message> send(SendAnimation animation) {
        return rt.exchange(
                url.getSendAnimation(),
                HttpMethod.POST,
                createHttpEntity(animation),
                new ParameterizedTypeReference<TLResponce<Message>>() {
                }).getBody();
    }

    private HttpEntity<?> createHttpEntity(SendPhoto photo) {
        if (StringUtils.hasText(photo.getPhotoId())) {
            return new HttpEntity<>(photo, bodyHeaders);
        }

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        insertMethodParams(photo, parts);
        parts.add(SendPhoto.PHOTO_ID, new HttpEntity<>(
                new FileSystemResource(photo.getPhotoFile()),
                getHeadersByFile(photo.getPhotoFile())
        ));
        return new HttpEntity<>(parts, multipartHeaders);
    }

    private HttpEntity<?> createHttpEntity(SendDocument document) {
        if (StringUtils.hasText(document.getDocumentId())) {
            return new HttpEntity<>(document, bodyHeaders);
        }

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        insertMethodParams(document, parts);
        parts.add(SendDocument.DOCUMENT_ID, new HttpEntity<>(
                new FileSystemResource(document.getDocumentFile()),
                getHeadersByFile(document.getDocumentFile())
        ));
        return new HttpEntity<>(parts, multipartHeaders);
    }

    private HttpEntity<?> createHttpEntity(SendAnimation animation) {
        if (StringUtils.hasText(animation.getAnimationId())) {
            return new HttpEntity<>(animation, bodyHeaders);
        }

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        insertAnimationParams(animation, parts);
        parts.add(SendAnimation.ANIMATION_ID, new HttpEntity<>(
                new FileSystemResource(animation.getAnimationFile()),
                getHeadersByFile(animation.getAnimationFile())
        ));
        return new HttpEntity<>(parts, multipartHeaders);
    }

}
