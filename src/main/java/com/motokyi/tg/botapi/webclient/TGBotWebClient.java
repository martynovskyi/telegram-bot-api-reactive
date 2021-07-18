package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.api.methods.ForwardMessage;
import com.motokyi.tg.botapi.api.methods.GetUpdates;
import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendDocument;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendPhoto;
import com.motokyi.tg.botapi.api.types.Chat;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.TGResponce;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.api.types.User;
import com.motokyi.tg.botapi.components.properties.TelegramBotProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class TGBotWebClient implements TGWebClient {
    private final WebClient wc;

    public TGBotWebClient(TelegramBotProperties botProperties) {
        this.wc = WebClient.builder()
                .baseUrl(TGApiUrl.createHostUrl(botProperties))
                .filter(TGWebClientUtils.logRequest(log))
                .filter(TGWebClientUtils.logResponse(log))
                .build();
    }

    @Override
    public Mono<TGResponce<User>> getMe() {
        return wc.get()
                .uri(TGApiUrl.GET_ME)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<Chat>> getChat(String chatId) {
        return wc.get()
                .uri(TGApiUrl.GET_CHAT, chatId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<List<Update>>> getUpdates() {
        return wc.get()
                .uri(TGApiUrl.GET_UPDATES)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<List<Update>>> getUpdates(GetUpdates getUpdates) {
        return wc.post()
                .uri(TGApiUrl.GET_UPDATES)
                .bodyValue(getUpdates)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendMessage message) {
        return wc.post()
                .uri(TGApiUrl.SEND_MESSAGE)
                .bodyValue(message)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendPhoto photo) {
        return wc.post()
                .uri(TGApiUrl.SEND_PHOTO)
                .body(TGWebClientUtils.createBody(photo))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendDocument document) {
        return wc.post()
                .uri(TGApiUrl.SEND_DOCUMENT)
                .body(TGWebClientUtils.createBody(document))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendAnimation animation) {
        return wc.post()
                .uri(TGApiUrl.SEND_ANIMATION)
                .body(TGWebClientUtils.createBody(animation))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> forwardMessage(ForwardMessage forwardMessage) {
        return wc.post()
                .uri(TGApiUrl.FORWARD_MESSAGE)
                .bodyValue(forwardMessage)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }
}