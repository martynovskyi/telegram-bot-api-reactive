package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.api.methods.*;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.TGResponce;
import com.motokyi.choiceness.telegram.api.types.Update;
import com.motokyi.choiceness.telegram.api.types.User;
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
}
