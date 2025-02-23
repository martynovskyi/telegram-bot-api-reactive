package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.GetMyCommands;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_GetMyCommandsTest extends BotClientTest {
    @Test
    void unauthorized() {
        unauthorizedTest(botClient.send(new GetMyCommands()), ApiUrls.GET_MY_COMMANDS, HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.send(new GetMyCommands()), ApiUrls.GET_MY_COMMANDS, HttpMethod.POST);
    }
}
