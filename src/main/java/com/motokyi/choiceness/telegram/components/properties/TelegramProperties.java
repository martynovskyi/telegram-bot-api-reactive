package com.motokyi.choiceness.telegram.components.properties;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value = "telegram")
public class TelegramProperties {
    public List<TelegramBotProperties> bots;
}
