package com.motokyi.tg.bot_api.api.type.reaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The reaction is based on a custom emoji.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#reactiontypecustomemoji">ReactionTypeCustomEmoji</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReactionTypeCustomEmoji extends ReactionType {

    @JsonProperty(ApiProperties.CUSTOM_EMOJI_ID)
    private String customEmojiId;

}
