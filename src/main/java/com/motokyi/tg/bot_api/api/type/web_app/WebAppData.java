package com.motokyi.tg.bot_api.api.type.web_app;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Describes data sent from a Web App to the bot.
 * See <a href="WebAppData">https://core.telegram.org/bots/api#webappdata</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class WebAppData {

    private String data;

    @JsonProperty(ApiProperties.BUTTON_TEXT)
    private String buttonText;
}
