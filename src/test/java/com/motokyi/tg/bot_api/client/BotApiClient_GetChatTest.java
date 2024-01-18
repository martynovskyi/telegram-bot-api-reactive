package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetChatTest extends BotClientWireMockTest {
    private static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.getChat(CHAT_ID), ApiUrls.GET_CHAT, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() throws InterruptedException {
        tooManyRequestsTest(() -> botClient.getChat(CHAT_ID), ApiUrls.GET_CHAT, HttpMethod.GET);
    }
}
