package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import lombok.Data;

/**
 * This object represents a boost removed from a chat.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#chatboostremoved">ChatBoostRemoved</a>
 */
@Data
public class ChatBoostRemoved {

    private Chat chat;

    @JsonProperty(ApiProperties.BOOST_ID)
    private Long boostId;

    @JsonProperty(ApiProperties.REMOVE_DATE)
    private Integer removeDate;

    private ChatBoostSource source;
}