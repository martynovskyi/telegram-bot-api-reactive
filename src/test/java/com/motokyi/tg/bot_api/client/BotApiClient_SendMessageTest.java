package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendMessageTest extends BotClientWireMockTest {
    private static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(new SendMessage(CHAT_ID)), ApiUrls.SEND_MESSAGE, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() throws InterruptedException {
        tooManyRequestsTest(() -> botClient.send(new SendMessage(CHAT_ID)), ApiUrls.SEND_MESSAGE, HttpMethod.POST);
    }
}
