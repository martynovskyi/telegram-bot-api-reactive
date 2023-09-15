package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendDocument;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendDocument extends BotClientTest {
    public static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        SendDocument sendDocument = new SendDocument(CHAT_ID);
        sendDocument.setDocumentId("id123");
        unauthorizedTest(() -> botClient.send(sendDocument), ApiUrls.SEND_DOCUMENT, HttpMethod.POST);
    }
}
