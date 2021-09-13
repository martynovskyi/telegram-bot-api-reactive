package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * This object represents an answer of a user in a non-anonymous poll.
 * See <a href="PollAnswer">https://core.telegram.org/bots/api#pollanswer</a>
 */
@Data
public class PollAnswer {
    @JsonProperty("poll_id")
    private String pollId;

    private User user;

    @JsonProperty("option_ids")
    private List<Integer> optionIds;
}
