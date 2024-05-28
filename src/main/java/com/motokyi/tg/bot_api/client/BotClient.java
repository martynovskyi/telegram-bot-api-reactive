package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.*;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.bot.BotDescription;
import com.motokyi.tg.bot_api.api.type.bot.BotName;
import com.motokyi.tg.bot_api.api.type.bot.BotShortDescription;
import com.motokyi.tg.bot_api.api.type.chat.ChatFullInfo;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.api.type.update.WebhookInfo;
import com.motokyi.tg.bot_api.api.type.user.User;
import com.motokyi.tg.bot_api.utils.ClientUtils;
import com.motokyi.tg.bot_api.utils.RequestValidator;
import com.motokyi.tg.bot_api.utils.UriUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
    public Mono<Response<BotName>> getMyName(@Nullable String languageCode) {
        return wc.get()
                .uri(UriUtils.uriWithLanguageCode(ApiUrls.GET_MY_NAME, languageCode))
                .exchangeToMono(ClientUtils.responseHandler("GetMyName",
                        new ParameterizedTypeReference<Response<BotName>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> setMyName(@Nullable String name, @Nullable String languageCode) {
        RequestValidator.setMyName(name, languageCode);
        return wc.get()
                .uri(uri -> {
                    uri.path(ApiUrls.SET_MY_NAME);
                    UriUtils.nonBlankParam(uri, ApiProperties.NAME, name);
                    UriUtils.nonBlankParam(uri, ApiProperties.LANGUAGE_CODE, languageCode);
                    return uri.build();
                })
                .exchangeToMono(ClientUtils.responseHandler("SetMyName",
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<BotDescription>> getMyDescription(@Nullable String languageCode) {
        return wc.get()
                .uri(UriUtils.uriWithLanguageCode(ApiUrls.GET_MY_DESCRIPTION, languageCode))
                .exchangeToMono(ClientUtils.responseHandler("GetMyDescription",
                        new ParameterizedTypeReference<Response<BotDescription>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> setMyDescription(@Nullable String description, @Nullable String languageCode) {
        RequestValidator.setMyDescription(description, languageCode);
        return wc.get()
                .uri(ApiUrls.SET_MY_DESCRIPTION, uri -> {
                    UriUtils.nonBlankParam(uri, ApiProperties.DESCRIPTION, description);
                    UriUtils.nonBlankParam(uri, ApiProperties.LANGUAGE_CODE, languageCode);
                    return uri.build();
                })
                .exchangeToMono(ClientUtils.responseHandler("SetMyDescription",
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<BotShortDescription>> getMyShortDescription(@Nullable String languageCode) {
        return wc.get()
                .uri(UriUtils.uriWithLanguageCode(ApiUrls.GET_MY_SHORT_DESCRIPTION, languageCode))
                .exchangeToMono(ClientUtils.responseHandler("GetMyShortDescription",
                        new ParameterizedTypeReference<Response<BotShortDescription>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> setMyShortDescription(@Nullable String shortDescription, @Nullable String languageCode) {
        RequestValidator.setMyShortDescription(shortDescription, languageCode);
        return wc.get()
                .uri(uri -> {
                    uri.path(ApiUrls.SET_MY_SHORT_DESCRIPTION);
                    UriUtils.nonBlankParam(uri, ApiProperties.SHORT_DESCRIPTION, shortDescription);
                    UriUtils.nonBlankParam(uri, ApiProperties.LANGUAGE_CODE, languageCode);
                    return uri.build();
                })
                .exchangeToMono(ClientUtils.responseHandler("SetMyShortDescription",
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<ChatFullInfo>> getChat(@NotNull String chatId) {
        return wc.get()
                .uri(ApiUrls.GET_CHAT, uri -> uri.queryParam(ApiProperties.CHAT_ID, chatId).build())
                .exchangeToMono(ClientUtils.responseHandler("GetChat",
                        new ParameterizedTypeReference<Response<ChatFullInfo>>() {
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
    public Mono<Response<List<Update>>> getUpdates(@NotNull GetUpdates getUpdates) {
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
    public Mono<Response<Message>> send(@NotNull SendMessage message) {
        return wc.post()
                .uri(ApiUrls.SEND_MESSAGE)
                .bodyValue(message)
                .exchangeToMono(ClientUtils.responseHandler(message.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(@NotNull SendPhoto photo) {
        return wc.post()
                .uri(ApiUrls.SEND_PHOTO)
                .body(ClientUtils.createBody(photo))
                .exchangeToMono(ClientUtils.responseHandler(photo.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(@NotNull SendDocument document) {
        return wc.post()
                .uri(ApiUrls.SEND_DOCUMENT)
                .body(ClientUtils.createBody(document))
                .exchangeToMono(ClientUtils.responseHandler(document.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(@NotNull SendAnimation animation) {
        return wc.post()
                .uri(ApiUrls.SEND_ANIMATION)
                .body(ClientUtils.createBody(animation))
                .exchangeToMono(ClientUtils.responseHandler(animation.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(@NotNull SetMyCommands commands) {
        return wc.post()
                .uri(ApiUrls.SET_MY_COMMANDS)
                .bodyValue(commands)
                .exchangeToMono(ClientUtils.responseHandler(commands.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(@NotNull DeleteMyCommands deleteCommands) {
        return wc.post()
                .uri(ApiUrls.DELETE_MY_COMMANDS)
                .bodyValue(deleteCommands)
                .exchangeToMono(ClientUtils.responseHandler(deleteCommands.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<List<BotCommand>>> send(@NotNull GetMyCommands getMyCommands) {
        return wc.post()
                .uri(ApiUrls.GET_MY_COMMANDS)
                .bodyValue(getMyCommands)
                .exchangeToMono(ClientUtils.responseHandler(getMyCommands.getClass(),
                        new ParameterizedTypeReference<Response<List<BotCommand>>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> forwardMessage(@NotNull ForwardMessage forwardMessage) {
        return wc.post()
                .uri(ApiUrls.FORWARD_MESSAGE)
                .bodyValue(forwardMessage)
                .exchangeToMono(ClientUtils.responseHandler(forwardMessage.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(@NotNull EditMessageReplyMarkup editMessageReplyMarkup) {
        return wc.post()
                .uri(ApiUrls.EDIT_MESSAGE_REPLY_MARKUP)
                .bodyValue(editMessageReplyMarkup)
                .exchangeToMono(ClientUtils.responseHandler(editMessageReplyMarkup.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Message>> send(@NotNull EditMessageText editMessageText) {
        return wc.post()
                .uri(ApiUrls.EDIT_MESSAGE_TEXT)
                .bodyValue(editMessageText)
                .exchangeToMono(ClientUtils.responseHandler(editMessageText.getClass(),
                        new ParameterizedTypeReference<Response<Message>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(@NotNull AnswerCallbackQuery answerCallbackQuery) {
        return wc.post()
                .uri(ApiUrls.ANSWER_CALLBACK_QUERY)
                .bodyValue(answerCallbackQuery)
                .exchangeToMono(ClientUtils.responseHandler(answerCallbackQuery.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> deleteMessage(@NotNull Long chatId, @NotNull Long messageId) {
        return wc.get()
                .uri(ApiUrls.DELETE_MESSAGE,
                        uri -> uri.queryParam(ApiProperties.CHAT_ID, chatId)
                                .queryParam(ApiProperties.MESSAGE_ID, messageId)
                                .build()
                )
                .exchangeToMono(ClientUtils.responseHandler("DeleteMessage",
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(@NotNull SetMessageReaction setMessageReaction) {
        return wc.post()
                .uri(ApiUrls.SET_MESSAGE_REACTION)
                .bodyValue(setMessageReaction)
                .exchangeToMono(ClientUtils.responseHandler(setMessageReaction.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(@NotNull SetWebhook setWebhook) {
        return wc.post()
                .uri(ApiUrls.SET_WEBHOOK)
                .bodyValue(setWebhook)
                .exchangeToMono(ClientUtils.responseHandler(setWebhook.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<Boolean>> send(@NotNull DeleteWebhook deleteWebhook) {
        return wc.post()
                .uri(ApiUrls.DELETE_WEBHOOK)
                .bodyValue(deleteWebhook)
                .exchangeToMono(ClientUtils.responseHandler(deleteWebhook.getClass(),
                        new ParameterizedTypeReference<Response<Boolean>>() {
                        }));
    }

    @Override
    public Mono<Response<WebhookInfo>> getWebhookInfo() {
        return wc.get()
                .uri(ApiUrls.GET_WEBHOOK_INFO)
                .exchangeToMono(ClientUtils.responseHandler("WebhookInfo",
                        new ParameterizedTypeReference<Response<WebhookInfo>>() {
                        }));
    }
}