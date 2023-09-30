package com.motokyi.tg.bot_api.api.type.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display
 * the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot.
 * An exception is made for one-time keyboards that are hidden immediately after the user presses
 * a button (see ReplyKeyboardMarkup).
 * See <a href="ReplyKeyboardRemove">https://core.telegram.org/bots/api#replykeyboardremove</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyKeyboardRemove extends KeyboardMarkup {

    @JsonProperty("remove_keyboard")
    private Boolean removeKeyboard = Boolean.TRUE;

    private Boolean selective;
}
