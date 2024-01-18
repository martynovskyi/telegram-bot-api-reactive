package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SendAnimation;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SendAnimationTest extends BotClientWireMockTest {
    private static final String CHAT_ID = "test_chat";

    @NotNull
    private static SendAnimation buildSendAnimation() {
        SendAnimation sendAnimation = new SendAnimation(CHAT_ID);
        sendAnimation.setAnimation("id123");
        return sendAnimation;
    }

    @Test
    void unauthorized() throws InterruptedException {
        unauthorizedTest(() -> botClient.send(buildSendAnimation()), ApiUrls.SEND_ANIMATION, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() throws InterruptedException {
        tooManyRequestsTest(() -> botClient.send(buildSendAnimation()), ApiUrls.SEND_ANIMATION, HttpMethod.POST);
    }
}
