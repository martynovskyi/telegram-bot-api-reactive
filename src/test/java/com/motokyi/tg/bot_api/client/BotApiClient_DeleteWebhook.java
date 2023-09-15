package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.DeleteWebhook;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteWebhook extends BotClientTest {
    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(new DeleteWebhook()), ApiUrls.DELETE_WEBHOOK, HttpMethod.POST);
    }
}
