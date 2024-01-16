package com.motokyi.tg.bot_api.api.type.reaction;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The reaction is based on an emoji.
 * See <a href="ReactionTypeEmoji">https://core.telegram.org/bots/api#reactiontypeemoji</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReactionTypeEmoji extends ReactionType {

    private String emoji;
}
