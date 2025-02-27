package com.motokyi.tg.bot_api.api.type.background;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The background is filled using the selected color.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillsolid">BackgroundFillSolid</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundFillSolid extends BackgroundFill {
    private Integer color;
}
