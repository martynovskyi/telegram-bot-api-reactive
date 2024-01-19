package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.GetUpdates;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetUpdatesTest extends BotClientWireMockTest {

    @Test
    void unauthorized() {
        unauthorizedTest(botClient::getUpdates, ApiUrls.GET_UPDATES, HttpMethod.GET);
    }

    @Test
    void unauthorized_withOffset() {
        unauthorizedTest(() -> botClient.getUpdates(new GetUpdates()), ApiUrls.GET_UPDATES, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(botClient::getUpdates, ApiUrls.GET_UPDATES, HttpMethod.GET);
    }

    @Test
    void tooManyRequests_withOffset() {
        tooManyRequestsTest(() -> botClient.getUpdates(new GetUpdates()), ApiUrls.GET_UPDATES, HttpMethod.POST);
    }
}
