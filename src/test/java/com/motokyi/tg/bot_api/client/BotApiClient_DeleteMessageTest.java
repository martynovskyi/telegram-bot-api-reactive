package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteMessageTest extends BotClientTest {
    private static final Long CHAT_ID = 122333L;
    private static final Long MESSAGE_ID = 123L;
    private static final String OK_PATH = new DefaultUriBuilderFactory().expand(ApiUrls.DELETE_MESSAGE, CHAT_ID, MESSAGE_ID).toString();

    @Test
    void successful() throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));

        Response<Boolean> userResponse = botClient.deleteMessage(CHAT_ID, MESSAGE_ID).block();
        RecordedRequest request = mockServer.takeRequest();

        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals(HttpMethod.GET.name(), request.getMethod()),
                () -> assertEquals(OK_PATH, request.getPath()),
                () -> assertEquals(0, request.getBodySize())
        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.deleteMessage(CHAT_ID, MESSAGE_ID), OK_PATH, HttpMethod.GET);
    }
}
