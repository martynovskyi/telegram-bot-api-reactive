package com.motokyi.tg.bot_api.api.type.reaction;

import lombok.Data;

/**
 * This object describes the type of a reaction. Currently, it can be one of
 * - ReactionTypeEmoji
 * - ReactionTypeCustomEmoji
 * See <a href="ReactionType">https://core.telegram.org/bots/api#reactiontype</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class ReactionType {
    private String type;
}
