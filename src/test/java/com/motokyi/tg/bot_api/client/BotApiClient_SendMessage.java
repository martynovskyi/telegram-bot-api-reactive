package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendMessage extends BotClientTest {
    public static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        SendMessage sendMessage = new SendMessage(CHAT_ID);
        unauthorizedTest(() -> botClient.send(sendMessage), ApiUrls.SEND_MESSAGE, HttpMethod.POST);
    }
}
