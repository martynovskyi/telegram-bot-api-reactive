package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.*;
import com.motokyi.tg.bot_api.api.types.*;
import com.motokyi.tg.bot_api.api.types.command.BotCommand;
import com.motokyi.tg.bot_api.api.types.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.RequiredArgsConstructor;
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
    public Mono<Response<Chat>> getChat(Long chatId) {
        return client.getChat(String.valueOf(chatId));
    }

    @Override
    public Mono<Response<Chat>> getChat(String chatTag) {
        return client.getChat(chatTag);
    }

    @Override
    public SendMessage sendMessage(Long chatId) {
        return new SendMessage(String.valueOf(chatId), client);
    }

    @Override
    public SendMessage sendMessage(String chatTag) {
        return new SendMessage(chatTag, client);
    }

    @Override
    public Mono<Response<Message>> sendMessage(Long chatId, String text) {
        return new SendMessage(String.valueOf(chatId), client).text(text).send();
    }

    @Override
    public SendDocument sendDocument(Long chatId) {
        return new SendDocument(String.valueOf(chatId), client);
    }

    @Override
    public SendDocument sendDocument(String chatTag) {
        return new SendDocument(chatTag, client);
    }

    @Override
    public SendPhoto sendPhoto(Long chatId) {
        return new SendPhoto(String.valueOf(chatId), client);
    }

    @Override
    public SendPhoto sendPhoto(String chatTag) {
        return new SendPhoto(chatTag, client);
    }

    @Override
    public SendAnimation sendAnimation(Long chatId) {
        return new SendAnimation(String.valueOf(chatId), client);
    }

    @Override
    public SendAnimation sendAnimation(String chatTag) {
        return new SendAnimation(chatTag, client);
    }

    @Override
    public ForwardMessage forwardMessage(String chatId, Message message) {
        return new ForwardMessage(chatId, message, client);
    }

    @Override
    public ForwardMessage forwardMessage(String chatId, Long fromChatId, Long messageId) {
        return new ForwardMessage(chatId, fromChatId, messageId, client);
    }

    @Override
    public EditMessageReplyMarkup editMessageReplyMarkup(Long chatId, Long messageId) {
        return new EditMessageReplyMarkup(String.valueOf(chatId), String.valueOf(messageId), client);
    }

    @Override
    public Mono<Response<Boolean>> deleteMessage(Long chatId, Long messageId) {
        return client.deleteMessage(chatId, messageId);
    }

    @Override
    public SetMyCommands setMyCommands() {
        return new SetMyCommands(client);
    }

    @Override
    public Mono<Response<Boolean>> deleteMyCommands(BotCommandScope scope) {
        return new DeleteMyCommands(client).scope(scope).send();
    }

    @Override
    public Mono<Response<List<BotCommand>>> getMyCommands(BotCommandScope scope) {
        return new GetMyCommands(client).scope(scope).send();
    }
}