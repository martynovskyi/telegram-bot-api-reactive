package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetWebhookInfoTest extends BotClientTest {
    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(botClient::getWebhookInfo, ApiUrls.GET_WEBHOOK_INFO, HttpMethod.GET);
    }
}
