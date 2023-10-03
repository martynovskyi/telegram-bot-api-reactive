package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.MockServerUtils;
import com.motokyi.tg.bot_api.api.type.Response;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class BotClientTest {

    static MockWebServer mockServer;

    BotClient botClient;

    @BeforeAll
    public static void setUp() throws IOException {
        mockServer = new MockWebServer();
        mockServer.start();
    }

    @AfterAll
    public static void tearDown() throws IOException {
        mockServer.shutdown();
    }

    @BeforeEach
    public void initialize() {
        String baseUrl = String.format("http://%s:%s",
                mockServer.getHostName(),
                mockServer.getPort());
        botClient = new BotClient(WebClient.create(baseUrl));
    }

    <T> RecordedRequest unauthorizedTest(Supplier<Mono<Response<T>>> request, String expectedPath, HttpMethod expectedMethod) throws InterruptedException {
        mockServer.enqueue(MockServerUtils.mockUnauthorized());

        var userResponse = request.get().block();
        RecordedRequest serverRequest = mockServer.takeRequest();
        assertAll(
                () -> assertFalse(userResponse.isOk()),
                () -> assertNull(userResponse.getResult()),
                () -> assertEquals(401, userResponse.getErrorCode()),
                () -> assertEquals("Unauthorized", userResponse.getDescription()),
                () -> assertEquals(expectedMethod.name(), serverRequest.getMethod()),
                () -> assertEquals(expectedPath, serverRequest.getPath())
        );
        return serverRequest;
    }

    // TODO: 10/3/2023  create test for 429
    // check response example
    /*
{
  "ok": false,
  "error_code": 429,
  "description": "Too Many Requests: retry after 85489",
  "parameters": {
    "retry_after": 85489
  }
}
     */
}