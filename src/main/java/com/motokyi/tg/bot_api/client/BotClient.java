package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.*;
import com.motokyi.tg.bot_api.api.types.*;
import com.motokyi.tg.bot_api.api.types.command.BotCommand;
import com.motokyi.tg.bot_api.utils.ClientUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClientRequest;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
class BotClient implements BotApiClient {
    private final WebClient wc;

    @Override
    public Mono<Response<User>> getMe() {
        return wc.get()
                .uri(ApiUrls.GET_ME)
                .exchangeToMono(ClientUtils.responseHandler("GetMe",
                        new ParameterizedTypeReference<Response<User>>() {
                        }));
    }

    @Override
    public Mono<Response<Chat>> getChat(String chatId) {
        return wc.get()
                .uri(ApiUrls.GET_CHAT, chatId)
                .exchangeToMono(ClientUtils.responseHandler("GetChat",
                        new ParameterizedTypeReference<Response<Chat>>() {
                        }));
    }

    @Override
    public Mono<Response<List<Update>>> getUpdates() {
        return wc.get()
                .uri(ApiUrls.GET_UPDATES)
                .exchangeToMono(ClientUtils.responseHandler("GetUpdates",
                        new ParameterizedTypeReference<Response<List<Update>>>() {
                        }));
    }

    @Override
    public Mono<Response<List<Update>>> getUpdates(GetUpdates getUpdates) {
        return wc.post()
                .uri(ApiUrls.GET_UPDATES)
                .httpRequest(req -> {
                    HttpClientRequest reactorRequest = req.getNativeRequest();
                    final int timeout = Objects.nonNull(getUpdates.getTimeout()) && getUpdates.getTimeout() > 0
                            ? getUpdates.getTimeout() + 5
                            : 60;
                    reactorRequest.responseTimeout(Duration.ofSeconds(timeout));
                })
                .bodyValue(getUpdates)
                .exchangeToMono(ClientUtils.responseHandler(getUpdates.getClass(),
                        new ParameterizedTypeReference<Response<List<Update>>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(SendMessage message) {
        return wc.post()
                .uri(ApiUrls.SEND_MESSAGE)
                .bodyValue(message)
                .exchangeToMono(ClientUtils.responseHandler(message.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(SendPhoto photo) {
        return wc.post()
                .uri(ApiUrls.SEND_PHOTO)
                .body(ClientUtils.createBody(photo))
                .exchangeToMono(ClientUtils.responseHandler(photo.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(SendDocument document) {
        return wc.post()
                .uri(ApiUrls.SEND_DOCUMENT)
                .body(ClientUtils.createBody(document))
                .exchangeToMono(ClientUtils.responseHandler(document.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(SendAnimation animation) {
        return wc.post()
                .uri(ApiUrls.SEND_ANIMATION)
                .body(ClientUtils.createBody(animation))
                .exchangeToMono(ClientUtils.responseHandler(animation.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(SetMyCommands commands) {
        return wc.post()
                .uri(ApiUrls.SET_MY_COMMANDS)
                .bodyValue(commands)
                .exchangeToMono(ClientUtils.responseHandler(commands.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(DeleteMyCommands deleteCommands) {
        return wc.post()
                .uri(ApiUrls.DELETE_MY_COMMANDS)
                .bodyValue(deleteCommands)
                .exchangeToMono(ClientUtils.responseHandler(deleteCommands.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<List<BotCommand>>> send(GetMyCommands getMyCommands) {
        return wc.post()
                .uri(ApiUrls.GET_MY_COMMANDS)
                .bodyValue(getMyCommands)
                .exchangeToMono(ClientUtils.responseHandler(getMyCommands.getClass(),
                        new ParameterizedTypeReference<Response<List<BotCommand>>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> forwardMessage(ForwardMessage forwardMessage) {
        return wc.post()
                .uri(ApiUrls.FORWARD_MESSAGE)
                .bodyValue(forwardMessage)
                .exchangeToMono(ClientUtils.responseHandler(forwardMessage.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> editMessageReplyMarkup(EditMessageReplyMarkup editMessageReplyMarkup) {
        return wc.post()
                .uri(ApiUrls.EDIT_MESSAGE_REPLY_MARKUP)
                .bodyValue(editMessageReplyMarkup)
                .exchangeToMono(ClientUtils.responseHandler(editMessageReplyMarkup.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> deleteMessage(Long chatId, Long messageId) {
        return wc.get()
                .uri(ApiUrls.DELETE_MESSAGE, chatId, messageId)
                .exchangeToMono(ClientUtils.responseHandler("DeleteMessage",
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }
}