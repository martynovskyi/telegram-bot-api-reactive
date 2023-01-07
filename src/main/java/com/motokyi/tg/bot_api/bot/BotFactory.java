package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.client.BotApiClient;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface BotFactory {
    Optional<Bot> getBot(String botName);

    public Optional<BotApiClient> getClient(String botName);

    Set<String> botNames();

    Collection<Bot> bots();

    Collection<BotApiClient> clients();
}
