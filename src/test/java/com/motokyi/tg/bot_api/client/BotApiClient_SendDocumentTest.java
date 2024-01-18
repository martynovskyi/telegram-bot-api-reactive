package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendDocument;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendDocumentTest extends BotClientWireMockTest {
    private static final String CHAT_ID = "test_chat";

    @NotNull
    private static SendDocument buildSendDocument() {
        SendDocument sendDocument = new SendDocument(CHAT_ID);
        sendDocument.setDocumentId("id123");
        return sendDocument;
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(buildSendDocument()), ApiUrls.SEND_DOCUMENT, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() throws InterruptedException {
        tooManyRequestsTest(() -> botClient.send(buildSendDocument()), ApiUrls.SEND_DOCUMENT, HttpMethod.POST);
    }
}
