package com.motokyi.tg.bot_api.api.type.reaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Represents a reaction added to a message along with the number of times it was added.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#reactioncount">ReactionCount</a>
 */
@Data
public class ReactionCount {

    private ReactionType type;

    @JsonProperty(ApiProperties.TOTAL_COUNT)
    private Integer totalCount;
}
