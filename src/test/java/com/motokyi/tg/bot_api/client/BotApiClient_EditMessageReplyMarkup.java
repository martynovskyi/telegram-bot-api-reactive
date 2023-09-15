package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.EditMessageReplyMarkup;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_EditMessageReplyMarkup extends BotClientTest {
    public static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> {
            EditMessageReplyMarkup replyMarkup = new EditMessageReplyMarkup(CHAT_ID, "msg123");
            return botClient.editMessageReplyMarkup(replyMarkup);
        }, ApiUrls.EDIT_MESSAGE_REPLY_MARKUP, HttpMethod.POST);
    }
}