package com.motokyi.tg.bot_api.api.type.reaction;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The reaction is paid.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#reactiontypepaid">ReactionTypePaid</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReactionTypePaid extends ReactionType {}
