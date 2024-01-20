package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendPhoto;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendPhotoTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";

    @NotNull
    private static SendPhoto buildSendPhoto() {
        SendPhoto sendPhoto = new SendPhoto(CHAT_ID);
        sendPhoto.setPhotoId("id123");
        return sendPhoto;
    }

    @Test
    void unauthorized() {
        unauthorizedTest(() -> botClient.send(buildSendPhoto()), ApiUrls.SEND_PHOTO, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(() -> botClient.send(buildSendPhoto()), ApiUrls.SEND_PHOTO, HttpMethod.POST);
    }
}
