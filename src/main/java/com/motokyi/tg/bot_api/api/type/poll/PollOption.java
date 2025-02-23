package com.motokyi.tg.bot_api.api.type.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import java.util.List;
import lombok.Data;

/**
 * This object contains information about one answer option in a poll.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#polloption">PollOption</a>
 */
@Data
public class PollOption {

    private String text;

    @JsonProperty(ApiProperties.TEXT_ENTITIES)
    private List<MessageEntity> textEntities;

    @JsonProperty("voter_count")
    private Integer voterCount;
}
