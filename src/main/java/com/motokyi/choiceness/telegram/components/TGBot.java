package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.api.methods.*;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.api.types.Update;
import com.motokyi.choiceness.telegram.api.types.User;

import java.util.List;

public interface TGBot {
    TLResponce<User> getMe();

    TLResponce<List<Update>> getAllUpdates();

    GetUpdates getUpdates();

    TLResponce<Chat> getChat(Long chatId);

    TLResponce<Chat> getChat(String chatTag);

    SendMessage sendMessage(Long chatId);

    SendMessage sendMessage(String chatTag);

    SendDocument sendDocument(Long chatId);

    SendDocument sendDocument(String chatTag);

    SendPhoto sendPhoto(Long chatId);

    SendPhoto sendPhoto(String chatTag);

    SendAnimation sendAnimation(Long chatId);

    SendAnimation sendAnimation(String chatTag);
}
