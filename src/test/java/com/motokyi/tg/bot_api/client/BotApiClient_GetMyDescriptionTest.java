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
public class BotApiClient_GetMyDescriptionTest extends BotClientTest {

    private static final String LANGUAGE_CODE_VALUE = "uk";

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void successful(String languageCode) {
        stubFor(
                get(urlEqualTo(ApiUrls.GET_MY_DESCRIPTION))
                        .willReturn(WMUtils.fromJsonFile("body/bot-description.json")));

        var response = botClient.getMyDescription(languageCode).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertEquals(PropertyValues.BOT_DESCRIPTION, response.getResult().getDescription()));
    }

    @Test
    void successful_withLanguageCode() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.GET_MY_DESCRIPTION))
                        .withQueryParam(ApiProperties.LANGUAGE_CODE, equalTo(LANGUAGE_CODE_VALUE))
                        .willReturn(WMUtils.fromJsonFile("body/bot-description.json")));

        var response = botClient.getMyDescription(LANGUAGE_CODE_VALUE).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertEquals(PropertyValues.BOT_DESCRIPTION, response.getResult().getDescription()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(botClient.getMyDescription(null), ApiUrls.GET_MY_DESCRIPTION, HttpMethod.GET);
    }

    @Test
    void tooManyRequests_withLanguageCode() {
        unauthorizedTest(
                botClient.getMyDescription(LANGUAGE_CODE_VALUE),
                ApiUrls.GET_MY_DESCRIPTION,
                HttpMethod.GET);
    }
}
