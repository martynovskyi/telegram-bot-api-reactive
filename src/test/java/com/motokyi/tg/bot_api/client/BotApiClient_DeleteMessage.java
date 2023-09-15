package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteMessage extends BotClientTest {
    public static final Long CHAT_ID = 112233L;
    public static final Long MESSAGE_ID = 12345L;
    @Test
    void unauthorized() throws InterruptedException {
        String path = new DefaultUriBuilderFactory().expand(ApiUrls.DELETE_MESSAGE, CHAT_ID, MESSAGE_ID).toString();
        unauthorizedTest(() -> botClient.deleteMessage(CHAT_ID,MESSAGE_ID), path, HttpMethod.GET);
    }
}
