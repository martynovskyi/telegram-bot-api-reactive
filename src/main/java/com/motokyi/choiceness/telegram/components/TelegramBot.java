package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.api.methods.*;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.TGResponce;
import com.motokyi.choiceness.telegram.api.types.Update;
import com.motokyi.choiceness.telegram.api.types.User;
import com.motokyi.choiceness.telegram.webclient.TGBotWebClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class TelegramBot implements TGBot {
    private final TGBotWebClient rt;

    @Override
    public Mono<TGResponce<User>> getMe() {
        return rt.getMe();
    }

    @Override
    public Mono<TGResponce<List<Update>>> getAllUpdates() {
        return rt.getUpdates();
    }

    @Override
    public GetUpdates getUpdates() {
        return new GetUpdates(rt);
    }

    @Override
    public Mono<TGResponce<Chat>> getChat(Long chatId) {
        return rt.getChat(String.valueOf(chatId));
    }

    @Override
    public Mono<TGResponce<Chat>> getChat(String chatTag) {
        return rt.getChat(chatTag);
    }

    @Override
    public SendMessage sendMessage(Long chatId) {
        return new SendMessage(chatId, rt);
    }

    @Override
    public SendMessage sendMessage(String chatTag) {
        return new SendMessage(chatTag, rt);
    }

    @Override
    public SendDocument sendDocument(Long chatId) {
        return new SendDocument(chatId, rt);
    }

    @Override
    public SendDocument sendDocument(String chatTag) {
        return new SendDocument(chatTag, rt);
    }

    @Override
    public SendPhoto sendPhoto(Long chatId) {
        return new SendPhoto(chatId, rt);
    }

    @Override
    public SendPhoto sendPhoto(String chatTag) {
        return new SendPhoto(chatTag, rt);
    }

    @Override
    public SendAnimation sendAnimation(Long chatId) {
        return new SendAnimation(chatId, rt);
    }

    @Override
    public SendAnimation sendAnimation(String chatTag) {
        return new SendAnimation(chatTag, rt);
    }
}
