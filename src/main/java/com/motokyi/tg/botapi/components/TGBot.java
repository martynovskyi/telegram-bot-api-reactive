package com.motokyi.tg.botapi.components;

import com.motokyi.tg.botapi.api.methods.*;
import com.motokyi.tg.botapi.api.types.*;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TGBot {
    Mono<TGResponce<User>> getMe();

    Mono<TGResponce<List<Update>>> getAllUpdates();

    GetUpdates getUpdates();

    Mono<TGResponce<Chat>> getChat(Long chatId);

    Mono<TGResponce<Chat>> getChat(String chatTag);

    SendMessage sendMessage(Long chatId);

    SendMessage sendMessage(String chatTag);

    SendDocument sendDocument(Long chatId);

    SendDocument sendDocument(String chatTag);

    SendPhoto sendPhoto(Long chatId);

    SendPhoto sendPhoto(String chatTag);

    SendAnimation sendAnimation(Long chatId);

    SendAnimation sendAnimation(String chatTag);

    ForwardMessage forwardMessage(String chatId, Message message);

    ForwardMessage forwardMessage(String chatId, Long fromChatId, Long messageId);
}
