package com.motokyi.tg.bot_api.api.type.web_app;

import lombok.Data;

/**
 * Describes a Web App.
 * See <a href="WebAppInfo">https://core.telegram.org/bots/api#webappinfo</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class WebAppInfo {

    private String url;
}
