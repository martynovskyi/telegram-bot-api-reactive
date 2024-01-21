package com.motokyi.tg.bot_api.api.type.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object contains information about one answer option in a poll.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#polloption">PollOption</a>
 */
@Data
public class PollOption {

    private String text;

    @JsonProperty("voter_count")
    private Integer voterCount;
}
