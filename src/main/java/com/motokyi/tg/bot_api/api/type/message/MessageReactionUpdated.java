package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionType;
import com.motokyi.tg.bot_api.api.type.user.User;
import java.util.List;
import lombok.Data;

/**
 * This object represents a change of a reaction on a message performed by a user.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#messagereactionupdated">MessageReactionUpdated</a>
 */
@Data
public class MessageReactionUpdated {
    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    private User user;

    @JsonProperty(ApiProperties.ACTOR_CHAT)
    private Chat actorChat;

    private Integer date;

    @JsonProperty(ApiProperties.OLD_REACTION)
    private List<ReactionType> oldReaction;

    @JsonProperty(ApiProperties.NEW_REACTION)
    private List<ReactionType> newReaction;
}
