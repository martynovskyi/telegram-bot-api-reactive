package com.motokyi.tg.bot_api.api.type.web_app;

import lombok.Data;

/**
 * Describes a Web App.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#webappinfo">WebAppInfo</a>
 */
@Data
public class WebAppInfo {

    private String url;
}
