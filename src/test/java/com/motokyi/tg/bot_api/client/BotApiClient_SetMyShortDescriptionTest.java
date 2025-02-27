package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetMyShortDescriptionTest extends BotClientTest {

    private static final String DESCRIPTION = "Bot Description";
    private static final String LANGUAGE_CODE = "uk";

    @Test
    void successful() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.SET_MY_SHORT_DESCRIPTION))
                        .withQueryParam(ApiProperties.SHORT_DESCRIPTION, equalTo(DESCRIPTION))
                        .withQueryParam(ApiProperties.LANGUAGE_CODE, absent())
                        .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.setMyShortDescription(DESCRIPTION, null).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult()));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void successful_resetWithLanguageCode(String description) {
        stubFor(
                get(urlPathEqualTo(ApiUrls.SET_MY_SHORT_DESCRIPTION))
                        .withQueryParam(ApiProperties.SHORT_DESCRIPTION, absent())
                        .withQueryParam(ApiProperties.LANGUAGE_CODE, equalTo(LANGUAGE_CODE))
                        .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.setMyShortDescription(description, LANGUAGE_CODE).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.setMyShortDescription(DESCRIPTION, null),
                ApiUrls.SET_MY_SHORT_DESCRIPTION,
                HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.setMyShortDescription(DESCRIPTION, LANGUAGE_CODE),
                ApiUrls.SET_MY_SHORT_DESCRIPTION,
                HttpMethod.GET);
    }
}
