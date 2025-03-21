package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_getChatMemberCountTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";

    @Test
    void successful() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.GET_CHAT_MEMBER_COUNT))
                        .withQueryParam(ApiProperties.CHAT_ID, equalTo(CHAT_ID))
                        .willReturn(WMUtils.fromJsonFile("body/number-result.json")));

        var response = botClient.getChatMemberCount(CHAT_ID).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertEquals(2025, response.getResult()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.getChatMemberCount(CHAT_ID), ApiUrls.GET_CHAT_MEMBER_COUNT, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.getChatMemberCount(CHAT_ID), ApiUrls.GET_CHAT_MEMBER_COUNT, HttpMethod.GET);
    }
}
