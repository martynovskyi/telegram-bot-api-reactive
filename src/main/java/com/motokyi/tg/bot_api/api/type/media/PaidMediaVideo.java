package com.motokyi.tg.bot_api.api.type.media;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The paid media is a video.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#paidmediavideo">PaidMediaVideo</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PaidMediaVideo extends PaidMedia {
    private Video video;
}
