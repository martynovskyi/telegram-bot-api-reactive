package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_leaveChatTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";

    @Test
    void successful() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.LEAVE_CHAT))
                        .withQueryParam(ApiProperties.CHAT_ID, equalTo(CHAT_ID))
                        .willReturn(WMUtils.fromJsonFile("body/true-result.json")));

        var response = botClient.leaveChat(CHAT_ID).block();
        assertAll(() -> assertTrue(response.isOk()), () -> assertTrue(response.getResult()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(botClient.leaveChat(CHAT_ID), ApiUrls.LEAVE_CHAT, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(botClient.leaveChat(CHAT_ID), ApiUrls.LEAVE_CHAT, HttpMethod.GET);
    }
}
