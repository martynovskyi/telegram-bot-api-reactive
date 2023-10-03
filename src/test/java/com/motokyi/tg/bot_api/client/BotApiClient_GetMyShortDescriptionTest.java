package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.bot.BotShortDescription;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpMethod;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetMyShortDescriptionTest extends BotClientTest {

    private static final String BOT_SHORT_DESCRIPTION = "Bot Short Desc";
    private static final MockResponse SUCCESS_RESPONSE = MockServerUtils.mock200(
            Map.of("short_description", BOT_SHORT_DESCRIPTION));

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void successful(String languageCode) throws InterruptedException {
        mockServer.enqueue(SUCCESS_RESPONSE);

        Response<BotShortDescription> userResponse = botClient.getMyShortDescription(languageCode).block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertEquals(BOT_SHORT_DESCRIPTION, userResponse.getResult().getShortDescription()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.GET_MY_SHORT_DESCRIPTION, request.getPath())
        );
    }

    @Test
    void successful_withLanguageCode() throws InterruptedException {
        mockServer.enqueue(SUCCESS_RESPONSE);

        Response<BotShortDescription> userResponse = botClient.getMyShortDescription("uk").block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertEquals(BOT_SHORT_DESCRIPTION, userResponse.getResult().getShortDescription()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.GET_MY_SHORT_DESCRIPTION + "?language_code=uk", request.getPath())
        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.getMyShortDescription(null),
                ApiUrls.GET_MY_SHORT_DESCRIPTION,
                HttpMethod.GET);
    }

    @Test
    void unauthorized_withLanguageCode() throws InterruptedException {
        unauthorizedTest(() -> botClient.getMyShortDescription("uk"),
                ApiUrls.GET_MY_SHORT_DESCRIPTION + "?language_code=uk",
                HttpMethod.GET);
    }
}
