package com.motokyi.tg.bot_api.api.type.giveaway;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import java.util.List;
import lombok.Data;

/**
 * This object represents a message about a scheduled giveaway.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#giveaway">Giveaway</a>
 */
@Data
public class Giveaway {

    private List<Chat> chats;

    @JsonProperty(ApiProperties.WINNERS_SELECTION_DATE)
    private Long winnersSelectionDate;

    @JsonProperty(ApiProperties.WINNER_COUNT)
    private Integer winnerCount;

    @JsonProperty(ApiProperties.ONLY_NEW_MEMBERS)
    private Boolean onlyNewMembers;

    @JsonProperty(ApiProperties.HAS_PUBLIC_WINNERS)
    private Boolean hasPublicWinners;

    @JsonProperty(ApiProperties.PRIZE_DESCRIPTION)
    private String prizeDescription;

    @JsonProperty(ApiProperties.COUNTRY_CODES)
    private List<String> countryCodes;

    @JsonProperty(ApiProperties.PRIZE_STAR_COUNT)
    private Integer prizeStarCount;

    @JsonProperty(ApiProperties.PREMIUM_SUBSCRIPTION_MONTH_COUNT)
    private Integer premiumSubscriptionMonthCount;
}
