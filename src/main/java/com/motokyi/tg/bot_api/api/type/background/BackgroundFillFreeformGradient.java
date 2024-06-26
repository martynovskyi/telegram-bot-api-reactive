package com.motokyi.tg.bot_api.api.type.background;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The background is a freeform gradient that rotates after every message in the chat.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillfreeformgradient">BackgroundFillFreeformGradient</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundFillFreeformGradient extends BackgroundFill {
    private List<Integer> colors;
}
