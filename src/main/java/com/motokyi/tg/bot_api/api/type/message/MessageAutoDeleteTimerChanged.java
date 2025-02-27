package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a service message about a change in auto-delete timer settings.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#messageautodeletetimerchanged">MessageAutoDeleteTimerChanged</a>
 */
@Data
public class MessageAutoDeleteTimerChanged {

    @JsonProperty("message_auto_delete_time")
    private Integer messageAutoDeleteTime;
}
