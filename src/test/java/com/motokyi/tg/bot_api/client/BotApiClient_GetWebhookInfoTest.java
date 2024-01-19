package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetWebhookInfoTest extends BotClientWireMockTest {
    @Test
    void unauthorized() {
        unauthorizedTest(botClient::getWebhookInfo, ApiUrls.GET_WEBHOOK_INFO, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(botClient::getWebhookInfo, ApiUrls.GET_WEBHOOK_INFO, HttpMethod.GET);
    }
}
