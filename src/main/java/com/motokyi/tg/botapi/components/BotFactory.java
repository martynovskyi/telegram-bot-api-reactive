package com.motokyi.tg.botapi.components;

import com.motokyi.tg.botapi.components.properties.TelegramBotProperties;
import com.motokyi.tg.botapi.components.properties.TelegramProperties;
import com.motokyi.tg.botapi.webclient.TGBotWebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class BotFactory implements TGBotFactory {
    private static final Map<String, TGBot> BOTS = new ConcurrentHashMap<>();

    public BotFactory(TelegramProperties properties) {
        log.info("Reading bot config");
        if (properties != null && properties.bots != null && !properties.bots.isEmpty()) {
            for (TelegramBotProperties bot : properties.bots) {
                log.info("Found bot: {}, valid: {}", bot.name, bot.isValid());
                if (bot.isValid()) {
                    BOTS.put(bot.name, new TelegramBot(new TGBotWebClient(bot)));
                }
            }
        }
    }

    @Override
    public Optional<TGBot> get(String botName) {
        return Optional.ofNullable(BOTS.get(botName));
    }

    public Set<String> botNames() {
        return BOTS.keySet();

    }

    public Collection<TGBot> bots() {
        return BOTS.values();

    }
}
