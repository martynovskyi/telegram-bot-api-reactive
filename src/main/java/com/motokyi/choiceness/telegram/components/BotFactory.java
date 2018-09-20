package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.components.properties.TelegramBotProperties;
import com.motokyi.choiceness.telegram.components.properties.TelegramProperties;
import com.motokyi.choiceness.telegram.webclient.TGBotWebClient;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BotFactory implements TGBotFactory {
    private static final Map<String, TGBot> BOTS = new ConcurrentHashMap<>();

    public BotFactory(TelegramProperties properties) {
        if (properties != null && properties.bots != null && !properties.bots.isEmpty()) {
            for (TelegramBotProperties bot : properties.bots) {
                if (bot.isValid()) {
                    BOTS.put(bot.name, new TelegramBot(new TGBotWebClient(bot)));
                }
            }
        }
    }

    @Override
    public Optional<TGBot> get(String botName) {
        return Optional.of(BOTS.get(botName));
    }

    public Set<String> botNames() {
        return BOTS.keySet();

    }

    public Collection<TGBot> bots() {
        return BOTS.values();

    }
}
