package com.motokyi.tg.bot_api.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object contains information about one answer option in a poll.
 * See <a href="PollOption">https://core.telegram.org/bots/api#polloption</a>
 */
@Data
public class PollOption {
    private String text;

    @JsonProperty("voter_count")
    private Integer voterCount;
}
