package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendAnimation;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendAnimationTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";

    @Test
    void unauthorized() throws InterruptedException {
        SendAnimation sendAnimation = new SendAnimation(CHAT_ID);
        sendAnimation.setAnimation("id123");
        unauthorizedTest(() -> botClient.send(sendAnimation), ApiUrls.SEND_ANIMATION, HttpMethod.POST);
    }
}
