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
public class BotApiClient_SetMyDescriptionTest extends BotClientTest {

    private static final String DESCRIPTION = "Unit Bot Test Description";

    @Test
    void successful() throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));

        Response<Boolean> userResponse = botClient.setMyDescription(DESCRIPTION, null).block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.SET_MY_DESCRIPTION + "?description=Unit%20Bot%20Test%20Description", request.getPath())
        );
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void successful_withLanguageCode(String description) throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));

        Response<Boolean> userResponse = botClient.setMyDescription(description, "uk").block();
        RecordedRequest request = mockServer.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.SET_MY_DESCRIPTION + "?language_code=uk", request.getPath())
        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.setMyDescription(DESCRIPTION, null),
                ApiUrls.SET_MY_DESCRIPTION +  "?description=Unit%20Bot%20Test%20Description",
                HttpMethod.GET);
    }

    @Test
    void unauthorized_withLanguageCode() throws InterruptedException {
        unauthorizedTest(() -> botClient.setMyDescription(DESCRIPTION, "uk"),
                ApiUrls.SET_MY_DESCRIPTION + "?description=Unit%20Bot%20Test%20Description&language_code=uk",
                HttpMethod.GET);
    }
}
