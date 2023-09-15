package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.User;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetMe extends BotClientTest {
    @Test
    void successful() throws InterruptedException {
        Map<String, Object> properties = Map.of("id", 123456789L, "username", "unitTest", "is_bot",true);
        mockTelegramApi.enqueue(MockServerUtils.mock200(properties));

        Response<User> userResponse = botClient.getMe().block();
        RecordedRequest request = mockTelegramApi.takeRequest();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertEquals(properties.get("id"), userResponse.getResult().getId()),
                () -> assertEquals(properties.get("username"), userResponse.getResult().getUserName()),
                () -> assertEquals(properties.get("is_bot"), userResponse.getResult().getIsBot()),
                () -> assertEquals("GET", request.getMethod()),
                () -> assertEquals(ApiUrls.GET_ME, request.getPath())
        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(botClient::getMe, ApiUrls.GET_ME, HttpMethod.GET);
    }
}
