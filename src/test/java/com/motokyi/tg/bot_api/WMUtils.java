package com.motokyi.tg.bot_api;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import org.springframework.http.MediaType;

/** Wire Mock utils */
public class WMUtils {

    public static ResponseDefinitionBuilder jsonWithResultTrue() {
        return fromJsonFile("body/true-result.json");
    }

    public static ResponseDefinitionBuilder jsonWithResultMessageId() {
        return fromJsonFile("body/message-id-result.json");
    }

    public static ResponseDefinitionBuilder jsonWithResultMessage() {
        return fromJsonFile("body/message-result.json");
    }

    public static ResponseDefinitionBuilder fromJsonFile(String fileName) {
        return aResponse()
                .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .withBodyFile(fileName);
    }

    public static String jsonPath(String... values) {
        return "$." + String.join(".", values);
    }
}
