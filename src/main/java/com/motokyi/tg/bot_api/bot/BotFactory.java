package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.client.BotApiClient;
import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.config.properties.TelegramBotProperties;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface BotFactory {
    /**
     * Get bot by given name
     *
     * @param botName the name of the bot correspond 'name' from 'telegram.bots[].name' configuration properties
     *                or {@link BotConfigProperty#getName()} in {@link TelegramBotProperties#getBots()}
     * @return bot if it presents
     */
    Optional<Bot> getBot(String botName);

    /**
     * Get client by given name
     *
     * @param botName the name of the bot correspond 'name' from 'telegram.bots[].name' configuration properties
     *                or {@link BotConfigProperty#getName()} in {@link TelegramBotProperties#getBots()}
     * @return bot if it presents
     */
    public Optional<BotApiClient> getClient(String botName);

    /**
     * Get all names of bots that are configured
     *
     * @return Set of bot names
     */
    Set<String> botNames();

    /**
     * Get all Bots that are configured
     *
     * @return bots
     */
    Collection<Bot> bots();
    /**
     * Get all Clients that are configured
     *
     * @return clients
     */
    Collection<BotApiClient> clients();
}
