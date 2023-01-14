package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.*;
import com.motokyi.tg.bot_api.api.type.*;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class TelegramBot implements Bot {
    private final BotApiClient client;

    @Override
    public Mono<Response<User>> getMe() {
        return client.getMe();
    }

    @Override
    public Mono<Response<List<Update>>> getAllUpdates() {
        return client.getUpdates();
    }

    @Override
    public GetUpdates getUpdates() {
        return new GetUpdates(client);
    }

    @Override
    public Mono<Response<Chat>> getChat(@NotNull Long chatId) {
        return client.getChat(String.valueOf(chatId));
    }

    @Override
    public Mono<Response<Chat>> getChat(@NotNull String chatTag) {
        return client.getChat(chatTag);
    }

    @Override
    public SendMessage sendMessage(@NotNull Long chatId) {
        return new SendMessage(String.valueOf(chatId), client);
    }

    @Override
    public SendMessage sendMessage(@NotNull String chatTag) {
        return new SendMessage(chatTag, client);
    }

    @Override
    public Mono<Response<Message>> sendMessage(@NotNull Long chatId, @NotNull String text) {
        return new SendMessage(String.valueOf(chatId), client).text(text).send();
    }

    @Override
    public SendDocument sendDocument(@NotNull Long chatId) {
        return new SendDocument(String.valueOf(chatId), client);
    }

    @Override
    public SendDocument sendDocument(@NotNull String chatTag) {
        return new SendDocument(chatTag, client);
    }

    @Override
    public SendPhoto sendPhoto(@NotNull Long chatId) {
        return new SendPhoto(String.valueOf(chatId), client);
    }

    @Override
    public SendPhoto sendPhoto(@NotNull String chatTag) {
        return new SendPhoto(chatTag, client);
    }

    @Override
    public SendAnimation sendAnimation(@NotNull Long chatId) {
        return new SendAnimation(String.valueOf(chatId), client);
    }

    @Override
    public SendAnimation sendAnimation(@NotNull String chatTag) {
        return new SendAnimation(chatTag, client);
    }

    @Override
    public ForwardMessage forwardMessage(@NotNull String chatId, @NotNull Message message) {
        return new ForwardMessage(chatId, message, client);
    }

    @Override
    public ForwardMessage forwardMessage(@NotNull String chatId, @NotNull Long fromChatId, @NotNull Long messageId) {
        return new ForwardMessage(chatId, fromChatId, messageId, client);
    }

    @Override
    public EditMessageReplyMarkup editMessageReplyMarkup(@NotNull Long chatId, @NotNull Long messageId) {
        return new EditMessageReplyMarkup(String.valueOf(chatId), String.valueOf(messageId), client);
    }

    @Override
    public Mono<Response<Boolean>> deleteMessage(@NotNull Long chatId, @NotNull Long messageId) {
        return client.deleteMessage(chatId, messageId);
    }

    @Override
    public SetMyCommands setMyCommands() {
        return new SetMyCommands(client);
    }

    @Override
    public Mono<Response<Boolean>> deleteMyCommands(@NotNull BotCommandScope scope) {
        return new DeleteMyCommands(client).scope(scope).send();
    }

    @Override
    public Mono<Response<List<BotCommand>>> getMyCommands(@NotNull BotCommandScope scope) {
        return new GetMyCommands(client).scope(scope).send();
    }

    @Override
    public SetWebhook setWebhook(@NotNull String url) {
        return new SetWebhook(client, url);
    }

    @Override
    public DeleteWebhook deleteWebhook() {
        return new DeleteWebhook(client);
    }

    @Override
    public Mono<Response<WebhookInfo>> getWebhookInfo() {
        return client.getWebhookInfo();
    }
}
