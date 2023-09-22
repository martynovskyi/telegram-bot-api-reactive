package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScopes;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteMyCommandsTest extends BotClientTest {
    @Test
    void successful() throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockValue(Boolean.TRUE));
        String languageCode = "uk";

        DeleteMyCommands deleteCommands = new DeleteMyCommands();
        deleteCommands.setScope(BotCommandScopes.DEFAULT);
        deleteCommands.setLanguageCode(languageCode);
        Response<Boolean> userResponse = botClient.send(deleteCommands).block();
        RecordedRequest request = mockServer.takeRequest();

        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertTrue(userResponse.getResult()),
                () -> assertEquals(HttpMethod.POST.name(), request.getMethod()),
                () -> assertEquals(ApiUrls.DELETE_MY_COMMANDS, request.getPath()),
                () -> assertTrue(request.getBodySize() > 1),
                () -> assertThatJson(request.getBody().readUtf8())
                        .isObject()
                        .containsEntry(ApiProperties.LANGUAGE_CODE, languageCode)
                        .node("scope")
                        .isObject()
                        .containsEntry("type", BotCommandScopes.DEFAULT.getType())
        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(new DeleteMyCommands()), ApiUrls.DELETE_MY_COMMANDS, HttpMethod.POST);
    }
}
