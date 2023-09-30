package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.method.payload.*;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.api.type.update.WebhookInfo;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.user.User;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BotApiClient {

    Mono<Response<User>> getMe();

    Mono<Response<List<Update>>> getUpdates();

    Mono<Response<List<Update>>> getUpdates(@NotNull GetUpdates getUpdates);

    Mono<Response<Chat>> getChat(@NotNull String chatTag);

    Mono<Response<Message>> send(@NotNull SendMessage message);

    Mono<Response<Message>> send(@NotNull SendPhoto document);

    Mono<Response<Message>> send(@NotNull SendDocument document);

    Mono<Response<Message>> send(@NotNull SendAnimation document);

    Mono<Response<Boolean>> send(@NotNull SetMyCommands commands);

    Mono<Response<Boolean>> send(@NotNull DeleteMyCommands commands);

    Mono<Response<List<BotCommand>>> send(@NotNull GetMyCommands getMyCommands);

    Mono<Response<Message>> forwardMessage(@NotNull ForwardMessage forwardMessage);

    Mono<Response<Message>> editMessageReplyMarkup(@NotNull EditMessageReplyMarkup editMessageReplyMarkup);

    Mono<Response<Boolean>> deleteMessage(@NotNull Long chatId, @NotNull Long messageId);

    Mono<Response<Boolean>> send(@NotNull SetWebhook setWebhook);

    Mono<Response<Boolean>> send(@NotNull DeleteWebhook deleteWebhook);

    Mono<Response<WebhookInfo>> getWebhookInfo();
}
