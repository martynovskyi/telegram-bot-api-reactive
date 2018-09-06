package com.motokyi.choiceness.telegram.resttemplate;

import com.motokyi.choiceness.telegram.api.methods.*;
import com.motokyi.choiceness.telegram.api.types.*;

import java.util.List;

public interface TelegramRT {

    TLResponce<User> getMe();

    TLResponce<List<Update>> getUpdates();

    TLResponce<List<Update>> getUpdates(GetUpdates getUpdates);

    TLResponce<Chat> getChat(Long chatId);

    TLResponce<Chat> getChat(String chatTag);

    TLResponce<Message> send(SendMessage message);

    TLResponce<Message> send(SendPhoto document);

    TLResponce<Message> send(SendDocument document);

    TLResponce<Message> send(SendAnimation document);
}
