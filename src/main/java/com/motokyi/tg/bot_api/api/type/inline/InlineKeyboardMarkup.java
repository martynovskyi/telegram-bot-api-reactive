package com.motokyi.tg.bot_api.api.type.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * See <a href="InlineKeyboardMarkup">https://core.telegram.org/bots/api#inlinekeyboardmarkup</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineKeyboardMarkup extends KeyboardMarkup {

    @JsonProperty("inline_keyboard")
    private List<List<InlineKeyboardButton>> inlineKeyboard;
}
