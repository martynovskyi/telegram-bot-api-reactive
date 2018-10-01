package com.motokyi.tg.botapi.components.properties;

import lombok.Setter;
import org.springframework.util.StringUtils;

@Setter
public class TelegramBotProperties {
    public String name;
    public String token;
    public String apiHost;

    public boolean isValid() {
        return StringUtils.hasText(name) && StringUtils.hasText(token);
    }
}