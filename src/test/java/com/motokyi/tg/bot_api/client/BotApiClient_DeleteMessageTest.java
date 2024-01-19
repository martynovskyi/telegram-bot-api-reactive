package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteMessageTest extends BotClientWireMockTest {
    private static final Long CHAT_ID = 122333L;
    private static final Long MESSAGE_ID = 123L;

    @Test
    void successful() {
        stubFor(get(urlPathEqualTo(ApiUrls.DELETE_MESSAGE))
                .withQueryParam(ApiProperties.CHAT_ID, equalTo(CHAT_ID.toString()))
                .withQueryParam(ApiProperties.MESSAGE_ID, equalTo(MESSAGE_ID.toString()))
                .willReturn(MockServerUtils.jsonWithResultTrue()));

        var response = botClient.deleteMessage(CHAT_ID, MESSAGE_ID).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult())
        );
    }

    @Test
    void unauthorized() {
        unauthorizedTest(() -> botClient.deleteMessage(CHAT_ID, MESSAGE_ID), ApiUrls.DELETE_MESSAGE, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(() -> botClient.deleteMessage(CHAT_ID, MESSAGE_ID), ApiUrls.DELETE_MESSAGE, HttpMethod.GET);
    }
}
