package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.DeleteWebhook;
import com.motokyi.tg.bot_api.api.type.Response;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteWebhookTest extends BotClientTest {
    @Test
    void successful() throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));

        DeleteWebhook deleteWebhook = new DeleteWebhook();
        deleteWebhook.setDropPendingUpdates(Boolean.TRUE);
        Response<Boolean> userResponse = botClient.send(deleteWebhook).block();
        RecordedRequest request = mockServer.takeRequest();

        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals(HttpMethod.POST.name(), request.getMethod()),
                () -> assertEquals(ApiUrls.DELETE_WEBHOOK, request.getPath()),
                () -> assertTrue(request.getBodySize() > 1),
                () -> assertThatJson(request.getBody().readUtf8())
                        .isObject()
                        .containsEntry(DeleteWebhook.DROP_PENDING_UPDATES_PROP, true)
        );
    }
    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(new DeleteWebhook()), ApiUrls.DELETE_WEBHOOK, HttpMethod.POST);
    }
}
