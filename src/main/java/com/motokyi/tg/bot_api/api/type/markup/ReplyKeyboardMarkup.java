package com.motokyi.tg.bot_api.api.type.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.keyboard.KeyboardButton;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * This object represents a custom keyboard with reply options
 * (see <a href="https://core.telegram.org/bots#keyboards">Introduction to bots</a> for details and examples).
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">ReplyKeyboardMarkup</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyKeyboardMarkup extends KeyboardMarkup {

    private List<List<KeyboardButton>> keyboard;

    @JsonProperty("is_persistent")
    private Boolean isPersistent;

    @JsonProperty("resize_keyboard")
    private Boolean resizeKeyboard;

    @JsonProperty("one_time_keyboard")
    private Boolean oneTimeKeyboard;

    @JsonProperty("input_field_placeholder")
    private String inputFieldPlaceholder;

    private Boolean selective;
}
