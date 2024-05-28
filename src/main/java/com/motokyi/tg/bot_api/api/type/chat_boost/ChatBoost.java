package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object contains information about a chat boost.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#chatboost">ChatBoost</a>
 */
@Data
public class ChatBoost {

    @JsonProperty(ApiProperties.BOOST_ID)
    private Long boostId;

    @JsonProperty(ApiProperties.ADD_DATE)
    private Integer addDate;

    @JsonProperty(ApiProperties.EXPIRATION_DATE)
    private Integer expirationDate;

    private ChatBoostSource source;
}
