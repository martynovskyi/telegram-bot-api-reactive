package com.motokyi.choiceness.telegram.resttemplate;

import com.motokyi.choiceness.telegram.api.methods.SendAnimation;
import com.motokyi.choiceness.telegram.api.methods.SendDocument;
import com.motokyi.choiceness.telegram.api.methods.SendMessage;
import com.motokyi.choiceness.telegram.api.methods.SendPhoto;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.Message;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.api.types.User;

public interface TelegramRT {

    TLResponce<User> getMe();

    void getUpdates();

    TLResponce<Chat> getChat(Long chatId);

    TLResponce<Chat> getChat(String chatTag);

    TLResponce<Message> send(SendMessage message);

    TLResponce<Message> send(SendPhoto document);

    TLResponce<Message> send(SendDocument document);

    TLResponce<Message> send(SendAnimation document);
}
