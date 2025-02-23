package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.motokyi.tg.bot_api.WMUtils.jsonPath;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.AnswerCallbackQuery;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_answerCallbackQuery extends BotClientTest {

    public static final String CALLBACK_ID = "callback_id";

    @Test
    void successful() {
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery(CALLBACK_ID);
        answerCallbackQuery.setText("text");
        answerCallbackQuery.setShowAlert(Boolean.TRUE);
        answerCallbackQuery.setUrl("http://test.url");
        answerCallbackQuery.setCacheTime(25);

        stubFor(
                post(urlEqualTo(ApiUrls.ANSWER_CALLBACK_QUERY))
                        .withRequestBody(
                                matchingJsonPath(jsonPath(ApiProperties.CALLBACK_QUERY_ID), equalTo(CALLBACK_ID))
                                        .and(
                                                matchingJsonPath(
                                                        jsonPath(ApiProperties.TEXT), equalTo(answerCallbackQuery.getText())))
                                        .and(matchingJsonPath(jsonPath(ApiProperties.SHOW_ALERT), equalTo("true")))
                                        .and(
                                                matchingJsonPath(
                                                        jsonPath(ApiProperties.URL), equalTo(answerCallbackQuery.getUrl())))
                                        .and(matchingJsonPath(jsonPath(ApiProperties.CACHE_TIME), equalTo("25"))))
                        .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.send(answerCallbackQuery).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.send(new AnswerCallbackQuery(CALLBACK_ID)),
                ApiUrls.ANSWER_CALLBACK_QUERY,
                HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.send(new AnswerCallbackQuery(CALLBACK_ID)),
                ApiUrls.ANSWER_CALLBACK_QUERY,
                HttpMethod.POST);
    }
}
