package com.motokyi.tg.bot_api.api.type.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">InlineKeyboardMarkup</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineKeyboardMarkup extends KeyboardMarkup {

    @JsonProperty("inline_keyboard")
    private List<List<InlineKeyboardButton>> inlineKeyboard;
}
