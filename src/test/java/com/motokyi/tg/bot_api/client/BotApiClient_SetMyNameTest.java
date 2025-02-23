package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetMyNameTest extends BotClientTest {

    private static final String BOT_NAME = "Unit_Bot";
    private static final String LANGUAGE_CODE = "uk";

    @Test
    void successful() {
        stubFor(get(urlPathEqualTo(ApiUrls.SET_MY_NAME))
                .withQueryParam(ApiProperties.NAME, equalTo(BOT_NAME))
                .withQueryParam(ApiProperties.LANGUAGE_CODE, absent())
                .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.setMyName(BOT_NAME, null).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult())
        );
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void successful_resetWithLanguageCode(String name) {
        stubFor(get(urlPathEqualTo(ApiUrls.SET_MY_NAME))
                .withQueryParam(ApiProperties.NAME, absent())
                .withQueryParam(ApiProperties.LANGUAGE_CODE, equalTo(LANGUAGE_CODE))
                .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.setMyName(name, LANGUAGE_CODE).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult())
        );
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.setMyName(BOT_NAME, null),
                ApiUrls.SET_MY_NAME,
                HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.setMyName(BOT_NAME, LANGUAGE_CODE),
                ApiUrls.SET_MY_NAME,
                HttpMethod.GET);
    }
}
