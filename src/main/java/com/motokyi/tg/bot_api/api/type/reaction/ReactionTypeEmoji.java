package com.motokyi.tg.bot_api.api.type.reaction;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The reaction is based on an emoji.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#reactiontypeemoji">ReactionTypeEmoji</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReactionTypeEmoji extends ReactionType {

    private String emoji;
}
