package com.motokyi.tg.bot_api.api.type.giveaway;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.NoArgsConstructor;

/**
 * This object represents a service message about the creation of a scheduled giveaway. Currently holds no information.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#giveawaycreated">GiveawayCreated</a>
 */

@NoArgsConstructor
public class GiveawayCreated {
    @JsonProperty(ApiProperties.PRIZE_STAR_COUNT)
    private Integer prizeStarCount;
}
