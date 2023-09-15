package com.motokyi.tg.bot_api;

import okhttp3.mockwebserver.MockResponse;
import org.springframework.http.MediaType;

import java.util.Map;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

public class MockServerUtils {

    public static MockResponse mock200(Map<String, Object> result) {
        StringBuilder data = new StringBuilder();
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            Object v = entry.getValue();
            data.append("\"").append(entry.getKey()).append("\" : ");

            if (v instanceof String s) {
                data.append("\"").append(s).append("\"");
            }
            if (v instanceof Number n) {
                data.append(n);
            }
            if (v instanceof Boolean b) {
                data.append(b);
            }

            data.append(", ");
        }
        return new MockResponse()
                .setResponseCode(200)
                .addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody("{ \"ok\": true, \"result\" : { " + data.substring(0, data.length() - 2) + " }}");
    }

    public static MockResponse mockUnauthorized(){
        return new MockResponse()
                .setResponseCode(401)
                .addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody("""
                            {
                                "ok": false,
                                "error_code": 401,
                                "description": "Unauthorized"
                            }
                        """);
    }
}
