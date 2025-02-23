package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.PropertyValues;
import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetChatTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";

    @Test
    void successful_private() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.GET_CHAT))
                        .withQueryParam(ApiProperties.CHAT_ID, equalTo(CHAT_ID))
                        .willReturn(WMUtils.fromJsonFile("body/private-chat.json")));

        var response = botClient.getChat(CHAT_ID).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertEquals(PropertyValues.ID, response.getResult().getId()),
                () -> assertEquals(PropertyValues.CHAT_TYPE_PRIVATE, response.getResult().getType()),
                () ->
                        assertEquals(PropertyValues.PRIVATE_USER_USERNAME, response.getResult().getUserName()),
                () -> assertEquals(PropertyValues.FIRST_NAME, response.getResult().getFirstName()),
                () -> assertEquals(PropertyValues.LAST_NAME_USER, response.getResult().getLastName()),
                () ->
                        assertThat(response.getResult().getActiveUsernames())
                                .hasSameElementsAs(PropertyValues.ACTIVE_USERNAMES),
                () ->
                        assertEquals(
                                PropertyValues.EMOJI_STATUS_CUSTOM_EMOJI_ID,
                                response.getResult().getEmojiStatusCustomEmojiId()));
    }

    // also, nice to have the following:
    //    void successful_group()
    //    void successful_supergroup()
    //    void successful_channel()

    @Test
    void unauthorized() {
        unauthorizedTest(botClient.getChat(CHAT_ID), ApiUrls.GET_CHAT, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(botClient.getChat(CHAT_ID), ApiUrls.GET_CHAT, HttpMethod.GET);
    }
}
