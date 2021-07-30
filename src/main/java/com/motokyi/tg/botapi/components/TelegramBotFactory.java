package com.motokyi.tg.botapi.components;

import com.motokyi.tg.botapi.components.properties.TelegramBotProperties;
import com.motokyi.tg.botapi.components.properties.TelegramProperties;
import com.motokyi.tg.botapi.webclient.BotClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class TelegramBotFactory implements BotFactory {
    private static final Map<String, Bot> BOTS = new ConcurrentHashMap<>();

    public TelegramBotFactory(TelegramProperties properties) {
        log.info("Reading bot config");
        if (properties != null && properties.bots != null && !properties.bots.isEmpty()) {
            for (TelegramBotProperties bot : properties.bots) {
                log.info("Found bot: {}, valid: {}", bot.name, bot.isValid());
                if (bot.isValid()) {
                    BOTS.put(bot.name, new TelegramBot(new BotClient(bot)));
                }
            }
        }
    }

    @Override
    public Optional<Bot> get(String botName) {
        return Optional.ofNullable(BOTS.get(botName));
    }

    public Set<String> botNames() {
        return BOTS.keySet();

    }

    public Collection<Bot> bots() {
        return BOTS.values();

    }
}
