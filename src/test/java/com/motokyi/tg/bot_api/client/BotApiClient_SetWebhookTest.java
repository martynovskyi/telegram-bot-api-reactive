package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SetWebhook;
import com.motokyi.tg.bot_api.api.type.Response;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetWebhookTest extends BotClientTest {
    private static final String URL = "https://test.me";

    @Test
    public void successful() throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));

        Response<Boolean> userResponse = botClient.send(new SetWebhook(URL)).block();
        RecordedRequest request = mockServer.takeRequest();

        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals(HttpMethod.POST.name(), request.getMethod()),
                () -> assertEquals(ApiUrls.SET_WEBHOOK, request.getPath()),
                () -> assertTrue(request.getBodySize() > 1L),
                () -> assertThatJson(request.getBody().readUtf8())
                        .isObject()
                        .containsEntry("url", URL)
        );
    }

    @Test
    public void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(new SetWebhook(URL)), ApiUrls.SET_WEBHOOK, HttpMethod.POST);
    }

}
