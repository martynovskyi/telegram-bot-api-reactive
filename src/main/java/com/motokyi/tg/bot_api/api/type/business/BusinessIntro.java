package com.motokyi.tg.bot_api.api.type.business;

import com.motokyi.tg.bot_api.api.type.sticker.Sticker;
import lombok.Data;

/**
 * Contains information about the start page settings of a Telegram Business account.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#businessintro">BusinessIntro</a>
 */
@Data
public class BusinessIntro {
    private String title;
    private String message;
    private Sticker sticker;
}
