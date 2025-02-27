package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The boost was obtained by the creation of a Telegram Premium or a Telegram Star giveaway. This
 * boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription for
 * Telegram Premium giveaways and prize_star_count / 500 times for one year for Telegram Star
 * giveaways.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#chatboostsourcegiveaway">ChatBoostSourceGiveaway</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChatBoostSourceGiveaway extends ChatBoostSource {

    @JsonProperty(ApiProperties.GIVEAWAY_MESSAGE_ID)
    private Long giveawayMessageId;

    private User user;

    @JsonProperty(ApiProperties.PRIZE_STAR_COUNT)
    private Integer prizeStarCount;

    @JsonProperty(ApiProperties.IS_UNCLAIMED)
    private Boolean isUnclaimed;
}
