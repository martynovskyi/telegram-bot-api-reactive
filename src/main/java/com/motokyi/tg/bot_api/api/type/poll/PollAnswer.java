package com.motokyi.tg.bot_api.api.type.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

import java.util.List;

/**
 * This object represents an answer of a user in a non-anonymous poll.
 * See <a href="PollAnswer">https://core.telegram.org/bots/api#pollanswer</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class PollAnswer {

    @JsonProperty("poll_id")
    private String pollId;

    @JsonProperty("voter_chat")
    private Chat voterChat;

    private User user;

    @JsonProperty("option_ids")
    private List<Integer> optionIds;
}
