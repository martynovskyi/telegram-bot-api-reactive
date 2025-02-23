package com.motokyi.tg.bot_api.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.exception.MissedBotConfigException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BotApiClientBuilderTest {
    private static final String API_HOST = "protocol://hostname.io";
    private static final String BOT_NAME = "test_bot";
    private static final String BOT_TOKEN = UUID.randomUUID().toString();

    private static BotConfigProperty buildValid() {
        BotConfigProperty properties = new BotConfigProperty();
        properties.setName(BOT_NAME);
        properties.setToken(BOT_TOKEN);
        properties.setApiHost(API_HOST);
        return properties;
    }

    @Test
    void build_withMissingBotProperties() {
        assertThrows(NullPointerException.class, () -> new BotApiClientBuilder().build());
    }

    @Test
    void build_withEmptyBotProperties() {
        assertThrows(
                MissedBotConfigException.class,
                () -> new BotApiClientBuilder().withBotProperties(new BotConfigProperty()).build());
    }

    @Test
    void build_withValidBotProperties() {
        BotApiClient apiClient = new BotApiClientBuilder().withBotProperties(buildValid()).build();
        assertNotNull(apiClient);
    }
}
