package com.motokyi.tg.bot_api.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Getter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value = "telegram")
public class TelegramProperties {
    private List<TelegramBotProperties> bots;
}
