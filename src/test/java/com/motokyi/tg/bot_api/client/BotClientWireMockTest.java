package com.motokyi.tg.bot_api.client;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.exception.TooManyRequestsException;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@WireMockTest
public class BotClientWireMockTest {
    BotClient botClient;

    @BeforeEach
    public void initialize(WireMockRuntimeInfo wireMockRuntime) {
        botClient = new BotClient(WebClient.create(wireMockRuntime.getHttpBaseUrl()));
    }

    <T> void unauthorizedTest(Supplier<Mono<Response<T>>> request, String expectedPath, HttpMethod expectedMethod) throws InterruptedException {
        stubFor(request(expectedMethod.name(), urlPathEqualTo(expectedPath))
                .willReturn(jsonResponse("""
                            {
                                "ok": false,
                                "error_code": 401,
                                "description": "Unauthorized"
                            }
                        """, HttpStatus.UNAUTHORIZED.value())));


        var userResponse = request.get().block();
        assertAll(
                () -> assertFalse(userResponse.isOk()),
                () -> assertNull(userResponse.getResult()),
                () -> assertEquals(HttpStatus.UNAUTHORIZED.value(), userResponse.getErrorCode()),
                () -> assertEquals("Unauthorized", userResponse.getDescription()));
    }

    <T> void tooManyRequestsTest(Supplier<Mono<Response<T>>> request, String expectedPath, HttpMethod expectedMethod) throws InterruptedException {
        stubFor(request(expectedMethod.name(), urlPathEqualTo(expectedPath))
                .willReturn(jsonResponse("""
                            {
                              "ok": false,
                              "error_code": 429,
                              "description": "Too Many Requests: retry after 85489",
                              "parameters": {
                                "retry_after": 85489
                              }
                            }
                        """, HttpStatus.TOO_MANY_REQUESTS.value())));

        var error = assertThrows(TooManyRequestsException.class, () -> request.get().block());
        Response<Void> response = error.getErrorResponse();
        assertAll(
                () -> assertFalse(response.isOk()),
                () -> assertNull(response.getResult()),
                () -> assertEquals(HttpStatus.TOO_MANY_REQUESTS.value(), response.getErrorCode()),
                () -> assertTrue(response.getDescription().startsWith("Too Many Requests:")),
                () -> assertNotNull(response.getParameters()),
                () -> assertEquals(85489, response.getParameters().getRetryAfter()));
    }
}