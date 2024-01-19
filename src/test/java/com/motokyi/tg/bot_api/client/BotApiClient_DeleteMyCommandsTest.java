package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScopes;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteMyCommandsTest extends BotClientWireMockTest {
    @Test
    void successful() {
        String languageCode = "uk";
        stubFor(post(urlPathEqualTo(ApiUrls.DELETE_MY_COMMANDS))
                .withRequestBody(matchingJsonPath(
                        MockServerUtils.jsonPath(ApiProperties.LANGUAGE_CODE),
                        equalTo(languageCode)))
                .withRequestBody(matchingJsonPath(
                        MockServerUtils.jsonPath(ApiProperties.SCOPE, ApiProperties.TYPE),
                        equalTo(BotCommandScopes.DEFAULT.getType())))
                .willReturn(MockServerUtils.jsonWithResultTrue()));

        DeleteMyCommands deleteCommands = new DeleteMyCommands();
        deleteCommands.setScope(BotCommandScopes.DEFAULT);
        deleteCommands.setLanguageCode(languageCode);
        Response<Boolean> response = botClient.send(deleteCommands).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult())

        );
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(new DeleteMyCommands()), ApiUrls.DELETE_MY_COMMANDS, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() throws InterruptedException {
        tooManyRequestsTest(() -> botClient.send(new DeleteMyCommands()), ApiUrls.DELETE_MY_COMMANDS, HttpMethod.POST);
    }
}
