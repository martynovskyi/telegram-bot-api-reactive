package com.motokyi.tg.bot_api.api.type;

import lombok.Data;

/**
 * This object represents an animated emoji that displays a random value.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#dice">Dice</a>
 */
@Data
public class Dice {

    private String emoji;

    private Integer value;
}
