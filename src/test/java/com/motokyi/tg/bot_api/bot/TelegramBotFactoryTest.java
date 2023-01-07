package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.client.BotApiClient;
import com.motokyi.tg.bot_api.config.properties.TelegramBotProperties;
import com.motokyi.tg.bot_api.config.properties.TelegramProperties;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TelegramBotFactoryTest {
    private static final String TEST_BOT = "test_bot";

    @Test
    void getBot_withValidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildValidProperties());
        Optional<Bot> bot = botFactory.getBot(TEST_BOT);
        assertTrue(bot.isPresent());
    }

    @Test
    void getBot_withInvalidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildInvalidProperties());
        Optional<Bot> bot = botFactory.getBot(TEST_BOT);
        assertFalse(bot.isPresent());
    }

    @Test
    void getClient_withValidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildValidProperties());
        Optional<BotApiClient> bot = botFactory.getClient(TEST_BOT);
        assertTrue(bot.isPresent());
    }

    @Test
    void getClient_withInvalidBot() {
        BotFactory botFactory = new TelegramBotFactory(buildInvalidProperties());
        Optional<BotApiClient> bot = botFactory.getClient(TEST_BOT);
        assertFalse(bot.isPresent());
    }

    @Test
    void botNames() {
        TelegramProperties properties = buildValidProperties();
        BotFactory botFactory = new TelegramBotFactory(properties);
        var names = botFactory.botNames();
        assertEquals(properties.getBots().size(), names.size());
    }

    @Test
    void bots() {
        TelegramProperties properties = buildValidProperties();
        BotFactory botFactory = new TelegramBotFactory(properties);
        var bots = botFactory.bots();
        assertEquals(properties.getBots().size(), bots.size());
    }

    @Test
    void clients() {
        TelegramProperties properties = buildValidProperties();
        BotFactory botFactory = new TelegramBotFactory(properties);
        var clients = botFactory.clients();
        assertEquals(properties.getBots().size(), clients.size());
    }

    private static TelegramProperties buildValidProperties() {
        TelegramProperties result = new TelegramProperties();
        var bots = new ArrayList<TelegramBotProperties>();
        bots.add(buildBotProperties(TEST_BOT));
        bots.add(buildBotProperties("other_bot"));
        result.setBots(bots);
        return result;
    }

    private static TelegramBotProperties buildBotProperties(String name) {
        TelegramBotProperties botProperties = new TelegramBotProperties();
        botProperties.setName(name);
        botProperties.setToken(UUID.randomUUID().toString());
        return botProperties;
    }

    private static TelegramProperties buildInvalidProperties() {
        TelegramProperties result = new TelegramProperties();
        var bots = new ArrayList<TelegramBotProperties>();
        TelegramBotProperties botProperties = new TelegramBotProperties();
        botProperties.setName(TEST_BOT);
        bots.add(botProperties);
        result.setBots(bots);
        return result;
    }
}