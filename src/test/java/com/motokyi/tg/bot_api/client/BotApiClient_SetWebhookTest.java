package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.motokyi.tg.bot_api.WMUtils.jsonPath;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.constant.UpdateTypes;
import com.motokyi.tg.bot_api.api.method.payload.SetWebhook;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetWebhookTest extends BotClientTest {
    private static final String URL = "https://test.me";

    @NotNull
    private static SetWebhook buildSetWebhook() {
        SetWebhook setWebhook = new SetWebhook(URL);
        setWebhook.setIpAddress("127.0.0.1");
        setWebhook.setMaxConnections(50);
        setWebhook.setAllowedUpdates(List.of(UpdateTypes.MESSAGE));
        setWebhook.setDropPendingUpdates(true);
        setWebhook.setSecretToken("ABC-123");
        return setWebhook;
    }

    @Test
    public void successful() {
        SetWebhook setWebhook = buildSetWebhook();
        stubFor(
                post(urlEqualTo(ApiUrls.SET_WEBHOOK))
                        .withRequestBody(
                                matchingJsonPath(jsonPath(ApiProperties.URL), equalTo(URL))
                                        .and(
                                                matchingJsonPath(
                                                        jsonPath(ApiProperties.IP_ADDRESS), equalTo(setWebhook.getIpAddress())))
                                        .and(
                                                matchingJsonPath(
                                                        jsonPath(ApiProperties.MAX_CONNECTIONS),
                                                        equalTo(setWebhook.getMaxConnections().toString())))
                                        .and(
                                                matchingJsonPath(
                                                        jsonPath(ApiProperties.ALLOWED_UPDATES), equalToJson("[\"message\"]")))
                                        .and(
                                                matchingJsonPath(
                                                        jsonPath(ApiProperties.SECRET_TOKEN),
                                                        equalTo(setWebhook.getSecretToken()))))
                        .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.send(setWebhook).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult()));
    }

    @Test
    public void unauthorized() {
        unauthorizedTest(botClient.send(new SetWebhook(URL)), ApiUrls.SET_WEBHOOK, HttpMethod.POST);
    }

    @Test
    public void tooManyRequests() {
        tooManyRequestsTest(botClient.send(new SetWebhook(URL)), ApiUrls.SET_WEBHOOK, HttpMethod.POST);
    }
}
