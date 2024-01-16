package com.motokyi.tg.bot_api.api.type.reaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Represents a reaction added to a message along with the number of times it was added.
 * See <a href="ReactionCount">https://core.telegram.org/bots/api#reactioncount</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class ReactionCount {

    private ReactionType type;

    @JsonProperty(ApiProperties.TOTAL_COUNT)
    private Integer totalCount;
}
