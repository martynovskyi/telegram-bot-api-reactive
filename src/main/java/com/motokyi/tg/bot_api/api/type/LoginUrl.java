package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a parameter of the inline keyboard button used to automatically authorize a user.
 * Serves as a great replacement for the Telegram Login Widget when the user is coming from Telegram.
 * All the user needs to do is tap/click a button and confirm that they want to log in.
 * Telegram apps support these buttons as of version 5.7.
 * <a href="LoginUrl">https://core.telegram.org/bots/api#loginurl</a>
 * <p>
 *
 * @version Bot API 6.9
 */

@Data
public class LoginUrl {

    private String url;

    @JsonProperty("forward_text")
    private String forwardText;

    @JsonProperty("bot_username")
    private String botUsername;

    @JsonProperty("request_write_access")
    private Boolean requestWriteAccess;
}
