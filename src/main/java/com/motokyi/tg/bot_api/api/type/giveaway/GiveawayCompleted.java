package com.motokyi.tg.bot_api.api.type.giveaway;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.Message;
import lombok.Data;

/**
 * This object represents a service message about the completion of a giveaway without public
 * winners.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#giveawaycompleted">GiveawayCompleted</a>
 */
@Data
public class GiveawayCompleted {

    @JsonProperty(ApiProperties.WINNER_COUNT)
    private Integer winnerCount;

    @JsonProperty(ApiProperties.UNCLAIMED_PRIZE_COUNT)
    private Integer unclaimedPrizeCount;

    @JsonProperty(ApiProperties.GIVEAWAY_MESSAGE)
    private Message giveawayMessage;

    @JsonProperty("is_star_giveaway")
    private Boolean isStarGiveaway;
}
