package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a service message about a user boosting a chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatboostadded">ChatBoostAdded</a>
 */
@Data
public class ChatBoostAdded {
    @JsonProperty(ApiProperties.BOOST_COUNT)
    private Integer boostCount;
}
