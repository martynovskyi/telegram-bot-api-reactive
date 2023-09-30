package com.motokyi.tg.bot_api.api.type;

import lombok.Data;

/**
 * This object represents an animated emoji that displays a random value.
 * See <a href="SwitchInlineQueryChosenChat">https://core.telegram.org/bots/api#dice</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class Dice {

    private String emoji;

    private Integer value;
}
