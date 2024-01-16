package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The boost was obtained by the creation of a Telegram Premium giveaway.
 * This boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.
 * See <a href="ChatBoostSourceGiveaway">https://core.telegram.org/bots/api#chatboostsourcegiveaway</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChatBoostSourceGiveaway extends ChatBoostSource {

    @JsonProperty(ApiProperties.GIVEAWAY_MESSAGE_ID)
    private Long giveawayMessageId;

    private User user;

    @JsonProperty(ApiProperties.IS_UNCLAIMED)
    private Boolean isUnclaimed;
}
