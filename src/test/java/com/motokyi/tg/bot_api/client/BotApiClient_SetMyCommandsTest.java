package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SetMyCommands;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetMyCommandsTest extends BotClientTest {
    @Test
    void unauthorized() {
        unauthorizedTest(botClient.send(new SetMyCommands()), ApiUrls.SET_MY_COMMANDS, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(botClient.send(new SetMyCommands()), ApiUrls.SET_MY_COMMANDS, HttpMethod.POST);
    }
}
