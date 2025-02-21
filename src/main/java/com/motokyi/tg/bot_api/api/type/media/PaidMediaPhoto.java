package com.motokyi.tg.bot_api.api.type.media;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The paid media is a photo.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#paidmediaphoto">PaidMediaPhoto</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PaidMediaPhoto extends PaidMedia {
    private List<PhotoSize> photo;
}
