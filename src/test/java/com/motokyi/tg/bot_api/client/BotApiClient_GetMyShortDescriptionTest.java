package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.PropertyValues;
import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetMyShortDescriptionTest extends BotClientTest {

    private static final String LANGUAGE_CODE_VALUE = "uk";

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void successful(String languageCode) {
        stubFor(
                get(urlEqualTo(ApiUrls.GET_MY_SHORT_DESCRIPTION))
                        .willReturn(WMUtils.fromJsonFile("body/bot-short-description.json")));

        var response = botClient.getMyShortDescription(languageCode).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () ->
                        assertEquals(
                                PropertyValues.BOT_SHORT_DESCRIPTION, response.getResult().getShortDescription()));
    }

    @Test
    void successful_withLanguageCode() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.GET_MY_SHORT_DESCRIPTION))
                        .withQueryParam(ApiProperties.LANGUAGE_CODE, equalTo(LANGUAGE_CODE_VALUE))
                        .willReturn(WMUtils.fromJsonFile("body/bot-short-description.json")));

        var response = botClient.getMyShortDescription(LANGUAGE_CODE_VALUE).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () ->
                        assertEquals(
                                PropertyValues.BOT_SHORT_DESCRIPTION, response.getResult().getShortDescription()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.getMyShortDescription(null), ApiUrls.GET_MY_SHORT_DESCRIPTION, HttpMethod.GET);
    }

    @Test
    void tooManyRequests_withLanguageCode() {
        tooManyRequestsTest(
                botClient.getMyShortDescription(LANGUAGE_CODE_VALUE),
                ApiUrls.GET_MY_SHORT_DESCRIPTION,
                HttpMethod.GET);
    }
}
