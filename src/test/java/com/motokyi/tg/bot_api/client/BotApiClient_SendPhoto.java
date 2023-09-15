package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendPhoto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendPhoto extends BotClientTest {
    public static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        SendPhoto sendPhoto = new SendPhoto(CHAT_ID);
        sendPhoto.setPhotoId("id123");
        unauthorizedTest(() -> botClient.send(sendPhoto), ApiUrls.SEND_PHOTO, HttpMethod.POST);
    }
}
