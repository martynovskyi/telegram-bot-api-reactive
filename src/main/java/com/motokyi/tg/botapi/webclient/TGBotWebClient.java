package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.api.methods.*;
import com.motokyi.tg.botapi.api.types.*;
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
                .bodyToMono(new ParameterizedTypeReference<TGResponce<User>>() {
                });
    }

    @Override
    public Mono<TGResponce<Chat>> getChat(String chatId) {
        return wc.get()
                .uri(TGApiUrl.GET_CHAT, chatId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Chat>>() {
                });
    }

    @Override
    public Mono<TGResponce<List<Update>>> getUpdates() {
        return wc.get()
                .uri(TGApiUrl.GET_UPDATES)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<List<Update>>>() {
                });
    }

    @Override
    public Mono<TGResponce<List<Update>>> getUpdates(GetUpdates getUpdates) {
        return wc.post()
                .uri(TGApiUrl.GET_UPDATES)
                .syncBody(getUpdates)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<List<Update>>>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendMessage message) {
        return wc.post()
                .uri(TGApiUrl.SEND_MESSAGE)
                .syncBody(message)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendPhoto photo) {
        return wc.post()
                .uri(TGApiUrl.SEND_PHOTO)
                .body(TGWebClientUtils.createBody(photo))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendDocument document) {
        return wc.post()
                .uri(TGApiUrl.SEND_DOCUMENT)
                .body(TGWebClientUtils.createBody(document))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendAnimation animation) {
        return wc.post()
                .uri(TGApiUrl.SEND_ANIMATION)
                .body(TGWebClientUtils.createBody(animation))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> forwardMessage(ForwardMessage forwardMessage) {
        return wc.post()
                .uri(TGApiUrl.FORWARD_MESSAGE)
                .syncBody(forwardMessage)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }
}