package com.motokyi.tg.bot_api.config.properties;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TelegramBotProperties {
    private List<BotConfigProperty> bots;
}
