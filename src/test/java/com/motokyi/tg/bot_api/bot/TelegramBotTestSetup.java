package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.client.BotApiClient;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public abstract class TelegramBotTestSetup {
    static final String TEST_TEXT = "Test text";
    static final Long CHAT_ID = 2023L;
    static final String CHAT_TAG = "test_chat";
    static final long MESSAGE_ID = 5445L;

    @Mock BotApiClient webClient;

    @InjectMocks TelegramBot bot;
}
