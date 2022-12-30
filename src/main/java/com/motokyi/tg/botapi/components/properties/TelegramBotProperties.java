package com.motokyi.tg.botapi.components.properties;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Setter
public class TelegramBotProperties {
    public String name;
    public String token;
    public String apiHost;

    public boolean isValid() {
        return StringUtils.isNotBlank(name) && StringUtils.isNotBlank(token);
    }
}