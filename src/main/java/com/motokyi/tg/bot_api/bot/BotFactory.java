package com.motokyi.tg.bot_api.bot;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface BotFactory {
    Optional<Bot> get(String botName);

    Set<String> botNames();

    Collection<Bot> bots();
}
