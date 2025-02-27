package com.motokyi.tg.bot_api.api.type.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.web_app.WebAppInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a menu button, which launches a Web App.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#menubuttonwebapp">MenuButtonWebApp</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuButtonWebApp extends MenuButton {

    private String text;

    @JsonProperty(ApiProperties.WEB_APP)
    private WebAppInfo webApp;
}
