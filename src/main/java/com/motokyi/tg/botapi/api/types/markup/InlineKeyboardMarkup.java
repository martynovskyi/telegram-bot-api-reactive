package com.motokyi.tg.botapi.api.types.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * See <a href="InlineKeyboardMarkup">https://core.telegram.org/bots/api#inlinekeyboardmarkup</a>
 * <p>
 * Field            Type	                                Description
 * inline_keyboard	Array of Array of InlineKeyboardButton	Array of button rows, each represented by an Array of InlineKeyboardButton objects
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineKeyboardMarkup extends KeyboardMarkup {

    @JsonProperty("inline_keyboard")
    private List<List<InlineKeyboardButton>> keyboard;
}
