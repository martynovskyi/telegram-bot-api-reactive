package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object contains information about a paid media purchase.
 *
 * @version Bot API 8.3
 * @see <a href="http://core.telegram.org/bots/api#paidmediapurchased">PaidMediaPurchased</a>
 */
@Data
public class PaidMediaPurchased {

    private User from;

    @JsonProperty("paid_media_payload")
    private String paidMediaPayload;
}
