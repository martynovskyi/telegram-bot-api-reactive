package com.motokyi.tg.bot_api.api.type.media;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The paid media isn't available before the payment.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#paidmediapreview">PaidMediaPreview</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PaidMediaPreview extends PaidMedia {
    private Integer width;
    private Integer height;
    private String duration;
}
