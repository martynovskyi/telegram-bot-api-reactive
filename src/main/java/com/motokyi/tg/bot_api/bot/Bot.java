package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.*;
import com.motokyi.tg.bot_api.api.type.*;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Convenient facade for all Bot API
 */
public interface Bot {
    Mono<Response<User>> getMe();

    Mono<Response<List<Update>>> getAllUpdates();

    GetUpdates getUpdates();

    Mono<Response<Chat>> getChat(@NotNull Long chatId);

    Mono<Response<Chat>> getChat(@NotNull String chatTag);

    SendMessage sendMessage(@NotNull Long chatId);

    SendMessage sendMessage(@NotNull String chatTag);

    SendMessage sendMessage(@NotNull Chat chat);

    Mono<Response<Message>> sendMessage(@NotNull Long chatId, @NotNull String text);

    Mono<Response<Message>> sendMessage(@NotNull Chat chat, @NotNull String text);

    SendDocument sendDocument(@NotNull Long chatId);

    SendDocument sendDocument(@NotNull String chatTag);

    SendPhoto sendPhoto(@NotNull Long chatId);

    SendPhoto sendPhoto(@NotNull String chatTag);

    SendAnimation sendAnimation(@NotNull Long chatId);

    SendAnimation sendAnimation(@NotNull String chatTag);

    ForwardMessage forwardMessage(@NotNull String chatId, @NotNull Message message);

    ForwardMessage forwardMessage(@NotNull String chatId, @NotNull Long fromChatId, @NotNull Long messageId);

    EditMessageReplyMarkup editMessageReplyMarkup(@NotNull Long chatId, @NotNull Long messageId);

    Mono<Response<Boolean>> deleteMessage(@NotNull Long chatId, @NotNull Long messageId);

    SetMyCommands setMyCommands();

    Mono<Response<Boolean>> deleteMyCommands(@NotNull BotCommandScope scope);

    Mono<Response<List<BotCommand>>> getMyCommands(@NotNull BotCommandScope scope);

    SetWebhook setWebhook(@NotNull String url);

    DeleteWebhook deleteWebhook();

    Mono<Response<WebhookInfo>> getWebhookInfo();
}
