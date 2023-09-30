package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a service message about a change in auto-delete timer settings.
 * See <a href="MessageAutoDeleteTimerChanged">https://core.telegram.org/bots/api#messageautodeletetimerchanged</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class MessageAutoDeleteTimerChanged {

    @JsonProperty("message_auto_delete_time")
    private Integer messageAutoDeleteTime;
}
