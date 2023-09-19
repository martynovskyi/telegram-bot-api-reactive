package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.ForwardMessage;
import com.motokyi.tg.bot_api.api.type.Chat;
import com.motokyi.tg.bot_api.api.type.Message;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_ForwardMessageTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";
    @Test
    void unauthorized() throws InterruptedException {
        Message message = new Message();
        message.setChat(new Chat());
        ForwardMessage forwardMessage = new ForwardMessage(CHAT_ID, message);
        unauthorizedTest(() -> botClient.forwardMessage(forwardMessage), ApiUrls.FORWARD_MESSAGE, HttpMethod.POST);
    }
}
