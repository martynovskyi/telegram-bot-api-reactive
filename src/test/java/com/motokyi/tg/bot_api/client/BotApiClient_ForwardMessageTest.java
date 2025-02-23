package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.ForwardMessage;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.message.Message;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_ForwardMessageTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";

    @NotNull
    private static ForwardMessage buildForwardMessage() {
        Message message = new Message();
        message.setChat(new Chat());
        ForwardMessage forwardMessage = new ForwardMessage(CHAT_ID, message);
        return forwardMessage;
    }

    @Test
    void unauthorized() {
        unauthorizedTest(botClient.forwardMessage(buildForwardMessage()), ApiUrls.FORWARD_MESSAGE, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(botClient.forwardMessage(buildForwardMessage()), ApiUrls.FORWARD_MESSAGE, HttpMethod.POST);
    }
}
