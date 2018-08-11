package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.components.properties.TelegramBotProperties;
import com.motokyi.choiceness.telegram.components.properties.TelegramProperties;
import com.motokyi.choiceness.telegram.resttemplate.TelegramApiUrl;
import com.motokyi.choiceness.telegram.resttemplate.TelegramBotRT;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BotFactory implements TGBotFactory {
    private static final Map<String, TGBot> BOTS = new ConcurrentHashMap<>();
    private final RestTemplate restTemplate;

    public BotFactory(TelegramProperties properties, RestTemplate rt) {
        this.restTemplate = rt;
        if (properties != null && properties.bots != null && !properties.bots.isEmpty()) {
            for (TelegramBotProperties bot : properties.bots) {
                if (bot.isValid()) {
                    BOTS.put(bot.name, new TelegramBot(new TelegramBotRT(rt, new TelegramApiUrl(bot))));
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
