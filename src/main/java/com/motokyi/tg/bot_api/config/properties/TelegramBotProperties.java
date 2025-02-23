package com.motokyi.tg.bot_api.config.properties;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelegramBotProperties {
    private List<BotConfigProperty> bots;
}
