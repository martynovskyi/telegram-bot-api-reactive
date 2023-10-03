package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.bot.BotDescription;
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
public class BotApiClient_GetMyDescriptionTest extends BotClientTest {

    private static final String BOT_DESCRIPTION = "Bot Description";
    private static final MockResponse SUCCESS_RESPONSE = MockServerUtils.mock200(
            Map.of("description", BOT_DESCRIPTION));

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void successful(String languageCode) throws InterruptedException {
        mockServer.enqueue(SUCCESS_RESPONSE);

        Response<BotDescription> userResponse = botClient.getMyDescription(languageCode).block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertEquals(BOT_DESCRIPTION, userResponse.getResult().getDescription()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.GET_MY_DESCRIPTION, request.getPath())
        );
    }

    @Test
    void successful_withLanguageCode() throws InterruptedException {
        mockServer.enqueue(SUCCESS_RESPONSE);

        Response<BotDescription> userResponse = botClient.getMyDescription("uk").block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertEquals(BOT_DESCRIPTION, userResponse.getResult().getDescription()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.GET_MY_DESCRIPTION + "?language_code=uk", request.getPath())
        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.getMyDescription(null),
                ApiUrls.GET_MY_DESCRIPTION,
                HttpMethod.GET);
    }

    @Test
    void unauthorized_withLanguageCode() throws InterruptedException {
        unauthorizedTest(() -> botClient.getMyDescription("uk"),
                ApiUrls.GET_MY_DESCRIPTION + "?language_code=uk",
                HttpMethod.GET);
    }
}
