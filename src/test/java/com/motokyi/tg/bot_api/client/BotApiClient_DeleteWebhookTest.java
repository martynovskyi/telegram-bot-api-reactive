package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.DeleteWebhook;
import com.motokyi.tg.bot_api.api.type.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteWebhookTest extends BotClientTest {
    @Test
    void successful() {
        stubFor(
                post(urlPathEqualTo(ApiUrls.DELETE_WEBHOOK))
                        .withRequestBody(
                                matchingJsonPath(
                                        WMUtils.jsonPath(ApiProperties.DROP_PENDING_UPDATES), equalTo("true")))
                        .willReturn(WMUtils.jsonWithResultTrue()));

        DeleteWebhook deleteWebhook = new DeleteWebhook();
        deleteWebhook.setDropPendingUpdates(Boolean.TRUE);
        Response<Boolean> response = botClient.send(deleteWebhook).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(botClient.send(new DeleteWebhook()), ApiUrls.DELETE_WEBHOOK, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.send(new DeleteWebhook()), ApiUrls.DELETE_WEBHOOK, HttpMethod.POST);
    }
}
