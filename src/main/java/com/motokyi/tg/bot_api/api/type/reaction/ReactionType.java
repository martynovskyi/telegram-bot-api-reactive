package com.motokyi.tg.bot_api.api.type.reaction;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.ReactionTypes;
import lombok.Data;

/**
 * This object describes the type of a reaction.
 * <ul> Currently, it can be one of
 * <li> ReactionTypeEmoji
 * <li> ReactionTypeCustomEmoji
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#reactiontype">ReactionType</a>
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ReactionTypeEmoji.class, name = ReactionTypes.EMOJI),
        @JsonSubTypes.Type(value = ReactionTypeCustomEmoji.class, name = ReactionTypes.CUSTOM_EMOJI)
})
public abstract class ReactionType {
    private String type;
}
