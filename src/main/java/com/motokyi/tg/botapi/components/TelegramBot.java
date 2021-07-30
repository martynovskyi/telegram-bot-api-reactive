package com.motokyi.tg.botapi.components;

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
import com.motokyi.tg.botapi.webclient.BotClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class TelegramBot implements Bot {
    private final BotClient client;

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
    public SendDocument sendDocument(Long chatId) {
        return new SendDocument(chatId, client);
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
}
