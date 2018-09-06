package com.motokyi.choiceness.telegram.api.types.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display
 * the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot.
 * An exception is made for one-time keyboards that are hidden immediately after the user presses
 * a button (see ReplyKeyboardMarkup).
 * See <a href="ReplyKeyboardRemove">https://core.telegram.org/bots/api#replykeyboardremove</a>
 * <p>
 * Field            Type	Description
 * remove_keyboard	True	Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
 * selective	    Boolean	Optional. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
 * Example: A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyKeyboardRemove extends ReplyMarkup {
    @JsonProperty("remove_keyboard")
    private Boolean removeKeyboard = Boolean.TRUE;

    private Boolean selective;
}
