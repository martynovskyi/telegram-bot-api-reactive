package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionCount;
import lombok.Data;

import java.util.List;

/**
 * This object represents reaction changes on a message with anonymous reactions.
 * See <a href="MessageReactionCountUpdated">https://core.telegram.org/bots/api#messagereactioncountupdated</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class MessageReactionCountUpdated {

    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    private Integer date;

    private List<ReactionCount> reactions;
}
