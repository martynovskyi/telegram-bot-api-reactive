package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetChat extends BotClientTest {
    public static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        String path = new DefaultUriBuilderFactory().expand(ApiUrls.GET_CHAT, CHAT_ID).toString();
        unauthorizedTest(() -> botClient.getChat(CHAT_ID), path, HttpMethod.GET);
    }
}
