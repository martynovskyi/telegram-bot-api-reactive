package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionCount;
import java.util.List;
import lombok.Data;

/**
 * This object represents reaction changes on a message with anonymous reactions.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#messagereactioncountupdated">MessageReactionCountUpdated</a>
 */
@Data
public class MessageReactionCountUpdated {

    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    private Integer date;

    private List<ReactionCount> reactions;
}
