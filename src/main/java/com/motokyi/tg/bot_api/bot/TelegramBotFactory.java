package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.client.BotApiClient;
import com.motokyi.tg.bot_api.client.BotApiClientBuilder;
import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.config.properties.TelegramBotProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static java.util.Objects.nonNull;

@Slf4j
public class TelegramBotFactory implements BotFactory {
    private final Map<String, BotApiClient> clients;
    private final Map<String, Bot> bots;

    public TelegramBotFactory(TelegramBotProperties properties) {
        log.info("Reading bot config");
        Map<String, Bot> bots = new HashMap<>();
        Map<String, BotApiClient> clients = new HashMap<>();
        if (nonNull(properties)
                && nonNull(properties.getBots())
                && !properties.getBots().isEmpty()) {
            for (BotConfigProperty bot : properties.getBots()) {
                log.info("Found bot: {}, valid: {}", bot.getName(), bot.isValid());
                if (bot.isValid()) {
                    BotApiClient client = BotApiClientBuilder.build(bot);
                    clients.put(bot.getName(), client);
                    bots.put(bot.getName(), new TelegramBot(client));
                }
            }
        }
        this.bots = Collections.unmodifiableMap(bots);
        this.clients = Collections.unmodifiableMap(clients);
    }

    @Override
    public Optional<Bot> getBot(String botName) {
        return Optional.ofNullable(bots.get(botName));
    }

    @Override
    public Optional<BotApiClient> getClient(String botName) {
        return Optional.ofNullable(clients.get(botName));
    }

    @Override
    public Set<String> botNames() {
        return bots.keySet();
    }

    @Override
    public Collection<Bot> bots() {
        return bots.values();
    }

    @Override
    public Collection<BotApiClient> clients() {
        return clients.values();
    }
}