package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.PropertyValues;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetMeTest extends BotClientWireMockTest {
    @Test
    void successful() {
        stubFor(get(urlEqualTo(ApiUrls.GET_ME))
                .willReturn(MockServerUtils.fromJsonFile("body/test-bot-user.json")));

        Response<User> response = botClient.getMe().block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertEquals(PropertyValues.ID, response.getResult().getId()),
                () -> assertEquals(PropertyValues.USERNAME, response.getResult().getUserName()),
                () -> assertEquals(PropertyValues.IS_BOT, response.getResult().getIsBot()),
                () -> assertEquals(PropertyValues.FIRST_NAME, response.getResult().getFirstName()),
                () -> assertEquals(PropertyValues.LAST_NAME_BOT, response.getResult().getLastName()),
                () -> assertTrue(response.getResult().getCanJoinGroups()),
                () -> assertTrue(response.getResult().getCanReadAllGroupMessages()),
                () -> assertTrue(response.getResult().getSupportsInlineQueries())
        );
    }


    @Test
    void unauthorized() {
        unauthorizedTest(botClient::getMe, ApiUrls.GET_ME, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(botClient::getMe, ApiUrls.GET_ME, HttpMethod.GET);
    }
}
