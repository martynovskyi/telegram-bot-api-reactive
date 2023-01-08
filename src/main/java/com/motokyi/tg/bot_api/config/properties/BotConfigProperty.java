package com.motokyi.tg.bot_api.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Setter
@Getter
public class BotConfigProperty {
    private String name;
    private String token;
    private String apiHost;

    public boolean isValid() {
        return StringUtils.isNotBlank(name) && StringUtils.isNotBlank(token);
    }
}