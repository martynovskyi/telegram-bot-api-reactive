package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScopes;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_DeleteMyCommandsTest extends BotClientTest {
    @Test
    void successful() {
        String languageCode = "uk";
        stubFor(
                post(urlPathEqualTo(ApiUrls.DELETE_MY_COMMANDS))
                        .withRequestBody(
                                matchingJsonPath(
                                        WMUtils.jsonPath(ApiProperties.LANGUAGE_CODE), equalTo(languageCode)))
                        .withRequestBody(
                                matchingJsonPath(
                                        WMUtils.jsonPath(ApiProperties.SCOPE, ApiProperties.TYPE),
                                        equalTo(BotCommandScopes.DEFAULT.getType())))
                        .willReturn(WMUtils.jsonWithResultTrue()));

        DeleteMyCommands deleteCommands = new DeleteMyCommands();
        deleteCommands.setScope(BotCommandScopes.DEFAULT);
        deleteCommands.setLanguageCode(languageCode);
        Response<Boolean> response = botClient.send(deleteCommands).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.send(new DeleteMyCommands()), ApiUrls.DELETE_MY_COMMANDS, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.send(new DeleteMyCommands()), ApiUrls.DELETE_MY_COMMANDS, HttpMethod.POST);
    }
}
