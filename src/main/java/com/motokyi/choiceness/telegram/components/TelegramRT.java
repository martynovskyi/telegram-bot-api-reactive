package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.api.methods.SendDocument;
import com.motokyi.choiceness.telegram.api.methods.SendMessage;
import com.motokyi.choiceness.telegram.api.methods.SendPhoto;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.Message;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.api.types.User;

import java.io.File;

public interface TelegramRT {

    TLResponce<User> getMe();

    void getUpdates();

    TLResponce<Chat> getChat(Long chatId);

    TLResponce<Chat> getChat(String chatTag);

    TLResponce<Message> sendMessage(SendMessage message);

    TLResponce<Message> sendMessage(Long chatId, String message);

    TLResponce<Message> sendMessage(String chatTag, String message);

    TLResponce<Message> sendPhoto(Long chatId, File image);

    TLResponce<Message> sendPhoto(SendPhoto document);

    TLResponce<Message> sendDocument(Long chatId, File document);

    TLResponce<Message> sendDocument(SendDocument document);
}