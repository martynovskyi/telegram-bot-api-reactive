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
public class BotApiClient_SetMyDescriptionTest extends BotClientTest {

    private static final String DESCRIPTION = "Test Description";
    private static final String LANGUAGE_CODE = "uk";

    @Test
    void successful() {
        stubFor(get(urlPathEqualTo(ApiUrls.SET_MY_DESCRIPTION))
                .withQueryParam(ApiProperties.DESCRIPTION, equalTo(DESCRIPTION))
                .withQueryParam(ApiProperties.LANGUAGE_CODE, absent())
                .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.setMyDescription(DESCRIPTION, null).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult())
        );
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void successful_resetWithLanguageCode(String description) {
        stubFor(get(urlPathEqualTo(ApiUrls.SET_MY_DESCRIPTION))
                .withQueryParam(ApiProperties.DESCRIPTION, absent())
                .withQueryParam(ApiProperties.LANGUAGE_CODE, equalTo(LANGUAGE_CODE))
                .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.setMyDescription(description, LANGUAGE_CODE).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult())
        );
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.setMyDescription(DESCRIPTION, null),
                ApiUrls.SET_MY_DESCRIPTION,
                HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.setMyDescription(DESCRIPTION, LANGUAGE_CODE),
                ApiUrls.SET_MY_DESCRIPTION,
                HttpMethod.GET);
    }
}
