package com.motokyi.tg.bot_api.api.type.forum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a service message about an edited forum topic.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#forumtopicedited">ForumTopicEdited</a>
 */
@Data
public class ForumTopicEdited {

    private String name;

    @JsonProperty(ApiProperties.ICON_CUSTOM_EMOJI_ID)
    private String iconCustomEmojiId;
}
