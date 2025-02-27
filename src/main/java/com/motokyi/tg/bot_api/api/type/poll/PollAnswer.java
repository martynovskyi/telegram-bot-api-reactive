package com.motokyi.tg.bot_api.api.type.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.user.User;
import java.util.List;
import lombok.Data;

/**
 * This object represents an answer of a user in a non-anonymous poll.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#pollanswer">PollAnswer</a>
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
