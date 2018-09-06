package com.motokyi.choiceness.telegram.api.types.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents one button of the reply keyboard. For simple text buttons String can be used instead
 * of this object to specify text of the button. Optional fields are mutually exclusive.
 * See <a href="KeyboardButton">https://core.telegram.org/bots/api#keyboardbutton</a>
 * <p>
 * Field            Type	   Description
 * text	            String	   Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * request_contact	Boolean	   Optional. If True, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
 * request_location	Boolean    Optional. If True, the user's current location will be sent when the button is pressed. Available in private chats only
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyboardButton {
    private String text;

    @JsonProperty("request_contact")
    private Boolean requestContact;

    @JsonProperty("request_location")
    private Boolean requestLocation;
}
