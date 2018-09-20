package com.motokyi.choiceness.telegram.webclient;

import com.motokyi.choiceness.telegram.api.methods.*;
import com.motokyi.choiceness.telegram.api.types.*;
import com.motokyi.choiceness.telegram.components.properties.TelegramBotProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.motokyi.choiceness.telegram.webclient.TGApiUrl.createHostUrl;
import static com.motokyi.choiceness.telegram.webclient.TGWebClientUtils.createBody;

@Slf4j
public class TGBotWebClient implements TGWebClient {
    private final WebClient wc;

    public TGBotWebClient(TelegramBotProperties botProperties) {
        this.wc = WebClient.builder()
                .baseUrl(createHostUrl(botProperties))
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
    public Mono<TGResponce<Chat>> getChat(Long chatId) {
        return getChat(String.valueOf(chatId));
    }

    @Override
    public Mono<TGResponce<Chat>> getChat(String chatTag) {
        return wc.get()
                .uri(TGApiUrl.GET_CHAT, chatTag)
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
                .body(createBody(photo))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendDocument document) {
        return wc.post()
                .uri(TGApiUrl.SEND_DOCUMENT)
                .body(createBody(document))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }

    @Override
    public Mono<TGResponce<Message>> send(SendAnimation animation) {
        return wc.post()
                .uri(TGApiUrl.SEND_ANIMATION)
                .body(createBody(animation))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<TGResponce<Message>>() {
                });
    }
}