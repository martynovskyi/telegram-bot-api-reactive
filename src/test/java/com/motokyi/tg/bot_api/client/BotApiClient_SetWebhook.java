package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SetWebhook;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetWebhook extends BotClientTest {
    public static final Long CHAT_ID = 112233L;
    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(new SetWebhook("http://test.it")), ApiUrls.SET_WEBHOOK, HttpMethod.POST);
    }
}
