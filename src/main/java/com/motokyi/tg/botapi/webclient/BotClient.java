package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.api.methods.ForwardMessage;
import com.motokyi.tg.botapi.api.methods.GetUpdates;
import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendDocument;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendPhoto;
import com.motokyi.tg.botapi.api.types.Chat;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.Response;
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
public class BotClient implements TGWebClient {
    private final WebClient wc;

    public BotClient(TelegramBotProperties botProperties) {
        this.wc = WebClient.builder()
                .baseUrl(ApiUrls.createHostUrl(botProperties))
                .filter(ClientUtils.logRequest(log))
                .filter(ClientUtils.logResponse(log))
                .build();
    }

    @Override
    public Mono<Response<User>> getMe() {
        return wc.get()
                .uri(ApiUrls.GET_ME)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<Chat>> getChat(String chatId) {
        return wc.get()
                .uri(ApiUrls.GET_CHAT, chatId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<List<Update>>> getUpdates() {
        return wc.get()
                .uri(ApiUrls.GET_UPDATES)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<List<Update>>> getUpdates(GetUpdates getUpdates) {
        return wc.post()
                .uri(ApiUrls.GET_UPDATES)
                .bodyValue(getUpdates)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<Message>> send(SendMessage message) {
        return wc.post()
                .uri(ApiUrls.SEND_MESSAGE)
                .bodyValue(message)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<Message>> send(SendPhoto photo) {
        return wc.post()
                .uri(ApiUrls.SEND_PHOTO)
                .body(ClientUtils.createBody(photo))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<Message>> send(SendDocument document) {
        return wc.post()
                .uri(ApiUrls.SEND_DOCUMENT)
                .body(ClientUtils.createBody(document))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<Message>> send(SendAnimation animation) {
        return wc.post()
                .uri(ApiUrls.SEND_ANIMATION)
                .body(ClientUtils.createBody(animation))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public Mono<Response<Message>> forwardMessage(ForwardMessage forwardMessage) {
        return wc.post()
                .uri(ApiUrls.FORWARD_MESSAGE)
                .bodyValue(forwardMessage)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }
}