package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.PropertyValues;
import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.bot.BotName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetMyNameTest extends BotClientTest {
    private static final String LANGUAGE_CODE_VALUE = "uk";

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void successful(String languageCode) {
        stubFor(get(urlEqualTo(ApiUrls.GET_MY_NAME))
                .willReturn(WMUtils.fromJsonFile("body/bot-name.json")));

        var response = botClient.getMyName(languageCode).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertEquals(PropertyValues.BOT_NAME, response.getResult().getName())
        );
    }

    @Test
    void successful_withLanguageCode() {
        stubFor(get(urlPathEqualTo(ApiUrls.GET_MY_NAME))
                .withQueryParam(ApiProperties.LANGUAGE_CODE, equalTo(LANGUAGE_CODE_VALUE))
                .willReturn(WMUtils.fromJsonFile("body/bot-name.json")));

        Response<BotName> userResponse = botClient.getMyName(LANGUAGE_CODE_VALUE).block();
        assertAll(
                () -> assertTrue(userResponse.isOk()),
                () -> assertNotNull(userResponse.getResult()),
                () -> assertEquals(PropertyValues.BOT_NAME, userResponse.getResult().getName())
        );
    }

    @Test
    void unauthorized() {
        unauthorizedTest(() -> botClient.getMyName(null), ApiUrls.GET_MY_NAME, HttpMethod.GET);
    }

    @Test
    void tooManyRequests_withLanguageCode() {
        tooManyRequestsTest(() -> botClient.getMyName(LANGUAGE_CODE_VALUE),
                ApiUrls.GET_MY_NAME,
                HttpMethod.GET);
    }
}
