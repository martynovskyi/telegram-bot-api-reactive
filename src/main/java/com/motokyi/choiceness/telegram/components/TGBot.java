package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.api.methods.SendAnimation;
import com.motokyi.choiceness.telegram.api.methods.SendDocument;
import com.motokyi.choiceness.telegram.api.methods.SendMessage;
import com.motokyi.choiceness.telegram.api.methods.SendPhoto;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.api.types.User;

public interface TGBot {
    TLResponce<User> getMe();

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
