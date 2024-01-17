package com.motokyi.tg.bot_api.api.type.giveaway;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

import java.util.List;

/**
 * This object represents a message about the completion of a giveaway with public winners.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#giveawaywinners">GiveawayWinners</a>
 */

@Data
public class GiveawayWinners {

    private Chat chat;

    @JsonProperty(ApiProperties.GIVEAWAY_MESSAGE_ID)
    private Long giveawayMessageId;

    @JsonProperty(ApiProperties.WINNERS_SELECTION_DATE)
    private Long winnersSelectionDate;

    @JsonProperty(ApiProperties.WINNER_COUNT)
    private Integer winnerCount;

    private List<User> winners;

    @JsonProperty(ApiProperties.ADDITIONAL_CHAT_COUNT)
    private Integer additionalChatCount;

    @JsonProperty(ApiProperties.PREMIUM_SUBSCRIPTION_MONTH_COUNT)
    private Integer premiumSubscriptionMonthCount;

    @JsonProperty(ApiProperties.UNCLAIMED_PRIZE_COUNT)
    private Integer unclaimedPrizeCount;

    @JsonProperty(ApiProperties.ONLY_NEW_MEMBERS)
    private Boolean onlyNewMembers;

    @JsonProperty(ApiProperties.WAS_REFUNDED)
    private Boolean wasRefunded;

    @JsonProperty(ApiProperties.PRIZE_DESCRIPTION)
    private String prizeDescription;
}
