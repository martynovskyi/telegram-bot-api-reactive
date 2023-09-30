package com.motokyi.tg.bot_api.api.type.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object contains information about the user whose identifier was shared wit
 * the bot using a KeyboardButtonRequestUser button.
 * See <a href="UserShared">https://core.telegram.org/bots/api#usershared</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class UserShared {

    @JsonProperty(ApiProperties.REQUEST_ID)
    private Long requestId;

    @JsonProperty(ApiProperties.USER_ID)
    private Long userId;
}
