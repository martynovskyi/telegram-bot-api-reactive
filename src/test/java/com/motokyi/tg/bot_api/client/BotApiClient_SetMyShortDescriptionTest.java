package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpMethod;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetMyShortDescriptionTest extends BotClientTest {

    private static final String DESCRIPTION = "Bot Description";

    @Test
    void successful() throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));

        Response<Boolean> userResponse = botClient.setMyShortDescription(DESCRIPTION, null).block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.SET_MY_SHORT_DESCRIPTION + "?short_description=Bot%20Description", request.getPath())
        );
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void successful_withLanguageCode(String description) throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));

        Response<Boolean> userResponse = botClient.setMyShortDescription(description, "uk").block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.SET_MY_SHORT_DESCRIPTION + "?language_code=uk", request.getPath())
        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.setMyShortDescription(DESCRIPTION, null),
                ApiUrls.SET_MY_SHORT_DESCRIPTION + "?short_description=Bot%20Description",
                HttpMethod.GET);
    }

    @Test
    void unauthorized_withLanguageCode() throws InterruptedException {
        unauthorizedTest(() -> botClient.setMyShortDescription(DESCRIPTION, "uk"),
                ApiUrls.SET_MY_SHORT_DESCRIPTION + "?short_description=Bot%20Description&language_code=uk",
                HttpMethod.GET);
    }
}
