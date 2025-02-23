package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import java.util.List;
import lombok.Data;

/**
 * Describes the paid media added to a message.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#paidmediainfo">PaidMediaInfo</a>
 */
@Data
public class PaidMediaInfo {

    @JsonProperty(ApiProperties.STAR_COUNT)
    private Integer starCount;

    @JsonProperty(ApiProperties.PAID_MEDIA)
    private List<PaidMedia> paidMedia;
}
