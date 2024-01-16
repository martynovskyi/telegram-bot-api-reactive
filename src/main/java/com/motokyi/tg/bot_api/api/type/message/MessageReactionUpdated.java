package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionType;
import lombok.Data;

import java.util.List;

/**
 * This object represents a change of a reaction on a message performed by a user.
 * See <a href="MessageReactionUpdated">https://core.telegram.org/bots/api#messagereactionupdated</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class MessageReactionUpdated {
    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;
    @JsonProperty(ApiProperties.ACTOR_CHAT)
    private Chat actorChat;

    private Integer date;

    @JsonProperty(ApiProperties.OLD_REACTION)
    private List<ReactionType> oldReaction;

    @JsonProperty(ApiProperties.NEW_REACTION)
    private List<ReactionType> newReaction;
}
