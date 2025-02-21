package com.motokyi.tg.bot_api.api.type.keyboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.web_app.WebAppInfo;
import lombok.Data;

/**
 * This object represents one button of the reply keyboard. At most one of the optional fields must be used
 * to specify type of the button.
 * For simple text buttons, String can be used instead of this object to specify the button text.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#keyboardbutton">KeyboardButton</a>
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyboardButton {

    private String text;

    @JsonProperty("request_users")
    private KeyboardButtonRequestUser requestUsers;

    @JsonProperty("request_chat")
    private KeyboardButtonRequestChat requestChat;

    @JsonProperty("request_contact")
    private Boolean requestContact;

    @JsonProperty("request_location")
    private Boolean requestLocation;

    @JsonProperty("request_poll")
    private KeyboardButtonPollType requestPoll;

    @JsonProperty(ApiProperties.WEB_APP)
    private WebAppInfo webApp;
}
