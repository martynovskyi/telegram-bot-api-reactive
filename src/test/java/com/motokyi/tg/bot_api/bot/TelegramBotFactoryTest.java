package com.motokyi.tg.bot_api.bot;

import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.client.BotApiClient;
import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.config.properties.TelegramBotProperties;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class TelegramBotFactoryTest {
    private static final String TEST_BOT = "test_bot";

    private static TelegramBotProperties buildValidProperties() {
        TelegramBotProperties result = new TelegramBotProperties();
        var bots = new ArrayList<BotConfigProperty>();
        bots.add(buildBotProperties(TEST_BOT, UUID.randomUUID().toString()));
        bots.add(buildBotProperties("other_bot", "test_token"));
        result.setBots(bots);
        return result;
    }

    private static BotConfigProperty buildBotProperties(String name, String token) {
        BotConfigProperty botProperties = new BotConfigProperty();
        botProperties.setName(name);
        botProperties.setToken(token);
        return botProperties;
    }

    private static TelegramBotProperties buildInvalidProperties() {
        TelegramBotProperties result = new TelegramBotProperties();
        var bots = new ArrayList<BotConfigProperty>();
        bots.add(buildBotProperties(TEST_BOT, null));
        result.setBots(bots);
        return result;
    }

    @Test
    void getBot_withValidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildValidProperties(), null);
        Optional<Bot> bot = botFactory.getBot(TEST_BOT);
        assertTrue(bot.isPresent());
    }

    @Test
    void getBot_withInvalidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildInvalidProperties(), null);
        Optional<Bot> bot = botFactory.getBot(TEST_BOT);
        assertFalse(bot.isPresent());
    }

    @Test
    void getClient_withValidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildValidProperties(), null);
        Optional<BotApiClient> bot = botFactory.getClient(TEST_BOT);
        assertTrue(bot.isPresent());
    }

    @Test
    void getClient_withInvalidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildInvalidProperties(), null);
        Optional<BotApiClient> bot = botFactory.getClient(TEST_BOT);
        assertFalse(bot.isPresent());
    }

    @Test
    void botNames() {
        TelegramBotProperties properties = buildValidProperties();
        BotFactory botFactory = new TelegramBotFactory(properties, null);
        var names = botFactory.botNames();
        assertEquals(properties.getBots().size(), names.size());
    }

    @Test
    void bots() {
        TelegramBotProperties properties = buildValidProperties();
        BotFactory botFactory = new TelegramBotFactory(properties, null);
        var bots = botFactory.bots();
        assertEquals(properties.getBots().size(), bots.size());
    }

    @Test
    void clients() {
        TelegramBotProperties properties = buildValidProperties();
        BotFactory botFactory = new TelegramBotFactory(properties, null);
        var clients = botFactory.clients();
        assertEquals(properties.getBots().size(), clients.size());
    }
}
