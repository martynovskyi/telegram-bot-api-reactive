package com.motokyi.tg.botapi.components;

import com.motokyi.tg.botapi.api.methods.ForwardMessage;
import com.motokyi.tg.botapi.api.methods.GetUpdates;
import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendDocument;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendPhoto;
import com.motokyi.tg.botapi.api.types.Chat;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.TGResponce;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.api.types.User;
import com.motokyi.tg.botapi.webclient.TGBotWebClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class TelegramBot implements TGBot {
    private final TGBotWebClient wc;

    @Override
    public Mono<TGResponce<User>> getMe() {
        return wc.getMe();
    }

    @Override
    public Mono<TGResponce<List<Update>>> getAllUpdates() {
        return wc.getUpdates();
    }

    @Override
    public GetUpdates getUpdates() {
        return new GetUpdates(wc);
    }

    @Override
    public Mono<TGResponce<Chat>> getChat(Long chatId) {
        return wc.getChat(String.valueOf(chatId));
    }

    @Override
    public Mono<TGResponce<Chat>> getChat(String chatTag) {
        return wc.getChat(chatTag);
    }

    @Override
    public SendMessage sendMessage(Long chatId) {
        return new SendMessage(String.valueOf(chatId), wc);
    }

    @Override
    public SendMessage sendMessage(String chatTag) {
        return new SendMessage(chatTag, wc);
    }

    @Override
    public SendDocument sendDocument(Long chatId) {
        return new SendDocument(chatId, wc);
    }

    @Override
    public SendDocument sendDocument(String chatTag) {
        return new SendDocument(chatTag, wc);
    }

    @Override
    public SendPhoto sendPhoto(Long chatId) {
        return new SendPhoto(String.valueOf(chatId), wc);
    }

    @Override
    public SendPhoto sendPhoto(String chatTag) {
        return new SendPhoto(chatTag, wc);
    }

    @Override
    public SendAnimation sendAnimation(Long chatId) {
        return new SendAnimation(String.valueOf(chatId), wc);
    }

    @Override
    public SendAnimation sendAnimation(String chatTag) {
        return new SendAnimation(chatTag, wc);
    }

    @Override
    public ForwardMessage forwardMessage(String chatId, Message message) {
        return new ForwardMessage(chatId, message, wc);
    }

    @Override
    public ForwardMessage forwardMessage(String chatId, Long fromChatId, Long messageId) {
        return new ForwardMessage(chatId, fromChatId, messageId, wc);
    }
}
