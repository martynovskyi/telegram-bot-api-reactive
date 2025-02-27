package com.motokyi.tg.bot_api;

import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.user.User;
import java.util.UUID;

public final class TestObjects {
    public static final Long CHAT_ID = 4000L;
    public static final Long USER_ID = 6000L;

    public static Chat chat() {
        Chat chat = new Chat();
        chat.setId(CHAT_ID);
        return chat;
    }

    public static User user() {
        User user = new User();
        user.setId(USER_ID);
        return user;
    }

    public static CallbackQuery callbackQuery(String query) {
        CallbackQuery callbackQuery = new CallbackQuery();
        callbackQuery.setId(UUID.randomUUID().toString());
        callbackQuery.setData(query);
        callbackQuery.setMessage(withText(""));
        return callbackQuery;
    }

    public static Message withText(String text) {
        Message message = new Message();
        message.setChat(TestObjects.chat());
        message.setFrom(TestObjects.user());
        message.setText(text);
        return message;
    }

    public static Response<Message> success() {
        Response<Message> response = new Response<>();
        response.setOk(true);
        Message message = new Message();
        message.setChat(TestObjects.chat());
        message.setFrom(TestObjects.user());
        response.setResult(message);
        return response;
    }

    public static Response<Boolean> successTrue() {
        Response<Boolean> response = new Response<>();
        response.setOk(true);
        response.setResult(true);
        return response;
    }

    public static Message buildMessage(String text) {
        Message message = new Message();
        message.setChat(TestObjects.chat());
        message.setFrom(TestObjects.user());
        message.setText(text);
        return message;
    }
}
