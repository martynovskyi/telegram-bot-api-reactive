package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.User;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

class BotClientTest {

    public static MockWebServer mockTelegramApi;

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

    @Test
    void getMe_successful() throws InterruptedException {
        mockTelegramApi.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("""
                        {
                        "ok": true,
                        "result" : {
                        "id": 123456789,
                        "username": "unitTest"
                        }
                        }
                        """)
                .addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));

        Response<User> userResponse = botClient.getMe().block();

        assertTrue(userResponse.isOk());
        assertNotNull(userResponse.getResult());
        assertEquals(123456789, userResponse.getResult().getId());
        assertEquals("unitTest", userResponse.getResult().getUserName());

        RecordedRequest request = mockTelegramApi.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals(ApiUrls.GET_ME, request.getPath());

    }

    @Test
    void getChat() {
    }

    @Test
    void getUpdates() {
    }

    @Test
    void testGetUpdates() {
    }

    @Test
    void send() {
    }

    @Test
    void testSend() {
    }

    @Test
    void testSend1() {
    }

    @Test
    void testSend2() {
    }

    @Test
    void testSend3() {
    }

    @Test
    void testSend4() {
    }

    @Test
    void testSend5() {
    }

    @Test
    void forwardMessage() {
    }

    @Test
    void editMessageReplyMarkup() {
    }

    @Test
    void deleteMessage() {
    }

    @Test
    void testSend6() {
    }

    @Test
    void testSend7() {
    }

    @Test
    void getWebhookInfo() {
    }
}