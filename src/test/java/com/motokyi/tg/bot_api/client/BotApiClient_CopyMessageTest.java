package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.CopyMessage;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_CopyMessageTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";
    private static final Long MESSAGE_ID = 135L;

    @NotNull
    private static CopyMessage buildCopyMessage() {
        CopyMessage copyMessage = new CopyMessage(CHAT_ID, CHAT_ID, MESSAGE_ID);
        return copyMessage;
    }

    @Test
    void successful() {
        stubFor(
                post(urlPathEqualTo(ApiUrls.COPY_MESSAGE))
                        .withRequestBody(
                                matchingJsonPath(WMUtils.jsonPath(ApiProperties.CHAT_ID), equalTo(CHAT_ID))
                                        .and(
                                                matchingJsonPath(
                                                        WMUtils.jsonPath(ApiProperties.FROM_CHAT_ID), equalTo(CHAT_ID)))
                                        .and(
                                                matchingJsonPath(
                                                        WMUtils.jsonPath(ApiProperties.MESSAGE_ID),
                                                        equalTo(MESSAGE_ID.toString()))))
                        .willReturn(WMUtils.jsonWithResultMessageId()));

        var response = botClient.copyMessage(buildCopyMessage()).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertEquals(123L, response.getResult().getMessageId()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.copyMessage(buildCopyMessage()), ApiUrls.COPY_MESSAGE, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.copyMessage(buildCopyMessage()), ApiUrls.COPY_MESSAGE, HttpMethod.POST);
    }
}
