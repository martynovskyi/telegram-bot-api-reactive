package com.motokyi.tg.bot_api.api.type.keyboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.web_app.WebAppInfo;
import lombok.Data;

/**
 * This object represents one button of the reply keyboard. For simple text buttons String can be used instead
 * of this object to specify text of the button. Optional fields are mutually exclusive.
 *
 * @version Bot API 6.9
 * @see <a href="https://core.telegram.org/bots/api#keyboardbutton">KeyboardButton</a>
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyboardButton {

    private String text;

    //todo: fix type
    @JsonProperty("request_user")
    private KeyboardButtonRequestUser requestUser;

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
