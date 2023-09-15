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

public abstract class BotClientTest {

    static MockWebServer mockTelegramApi;

    BotClient botClient;

    @BeforeAll
    static void setUp() throws IOException {
        mockTelegramApi = new MockWebServer();
        mockTelegramApi.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockTelegramApi.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://%s:%s",
                mockTelegramApi.getHostName(),
                mockTelegramApi.getPort());
        botClient = new BotClient(WebClient.create(baseUrl));
    }

    <T> RecordedRequest unauthorizedTest(Supplier<Mono<Response<T>>> request, String expectedPath, HttpMethod expectedMethod) throws InterruptedException {
        mockTelegramApi.enqueue(MockServerUtils.mockUnauthorized());

        var userResponse = request.get().block();
        RecordedRequest serverRequest = mockTelegramApi.takeRequest();
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
}