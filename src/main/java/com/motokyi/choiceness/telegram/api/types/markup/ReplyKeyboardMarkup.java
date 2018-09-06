package com.motokyi.choiceness.telegram.api.types.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * This object represents a custom keyboard with reply options
 * (see <a href="Introduction to bots">https://core.telegram.org/bots#keyboards</a> for details and examples).
 * See <a href="ReplyKeyboardMarkup">https://core.telegram.org/bots/api#replykeyboardmarkup</a>
 * <p>
 * Field                Type	                            Description
 * keyboard	            Array of Array of KeyboardButton	Array of button rows, each represented by an Array of KeyboardButton objects
 * resize_keyboard	    Boolean                             Optional. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of the same height as the app's standard keyboard.
 * one_time_keyboard	Boolean                             Optional. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to false.
 * selective	        Boolean                             Optional. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
 * Example: A user requests to change the bot‘s language, bot replies to the request with a keyboard to select the new language. Other users in the group don’t see the keyboard.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyKeyboardMarkup extends ReplyMarkup {

    private List<KeyboardButton> keyboard;

    @JsonProperty("resize_keyboard")
    private Boolean resizeKeyboard;

    @JsonProperty("one_time_keyboard")
    private Boolean oneTimeKeyboard;

    private Boolean selective;
}
