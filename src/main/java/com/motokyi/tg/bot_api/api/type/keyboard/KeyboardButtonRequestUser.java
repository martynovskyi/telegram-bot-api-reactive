package com.motokyi.tg.bot_api.api.type.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object defines the criteria used to request a suitable user.
 * The identifier of the selected user will be shared with the bot when the corresponding button is pressed.
 * See <a href="KeyboardButtonRequestUser">https://core.telegram.org/bots/api#keyboardbuttonrequestuser</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class KeyboardButtonRequestUser {

    @JsonProperty(ApiProperties.REQUEST_ID)
    private Long requestId;

    @JsonProperty("user_is_bot")
    private Boolean userIsBot;

    @JsonProperty("user_is_premium")
    private Boolean userIsPremium;
}
