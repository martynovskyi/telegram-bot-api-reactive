package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.components.properties.TelegramBotProperties;
import com.motokyi.tg.botapi.exception.RequiredConfigMissedTGException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TGApiUrlTest {

    private static final String BOT_NAME = "test_bot";
    private static final String BOT_TOKEN = UUID.randomUUID().toString();

    @Test
    void createHostUrl_nullProperties() {
        assertThrows(RequiredConfigMissedTGException.class, () ->
                TGApiUrl.createHostUrl(null));

    }

    @Test
    void createHostUrl_emptyProperties() {
        assertThrows(RequiredConfigMissedTGException.class, () ->
                TGApiUrl.createHostUrl(new TelegramBotProperties()));

    }

    @Test
    void createHostUrl_validProperties() {
        TelegramBotProperties properties = new TelegramBotProperties();
        properties.setName(BOT_NAME);
        properties.setToken(BOT_TOKEN);
        assertTrue(properties.isValid());

        String hostUrl = TGApiUrl.createHostUrl(properties);
        assertEquals(TGApiUrl.API_HOST + TGApiUrl.BOT_PREFIX + BOT_TOKEN, hostUrl);

    }

    @Test
    void createHostUrl_validPropertiesWithApiHost() {
        String apiHost = "protocol://hostname.io";
        TelegramBotProperties properties = new TelegramBotProperties();
        properties.setName(BOT_NAME);
        properties.setToken(BOT_TOKEN);
        properties.setApiHost(apiHost);
        assertTrue(properties.isValid());

        String hostUrl = TGApiUrl.createHostUrl(properties);
        assertEquals(apiHost + TGApiUrl.BOT_PREFIX + BOT_TOKEN, hostUrl);

    }
}