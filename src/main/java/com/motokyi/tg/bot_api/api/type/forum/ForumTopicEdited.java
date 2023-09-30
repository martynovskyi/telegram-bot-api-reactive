package com.motokyi.tg.bot_api.api.type.forum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a service message about an edited forum topic.
 * See <a href="ForumTopicEdited">https://core.telegram.org/bots/api#forumtopicedited</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ForumTopicEdited {

    private String name;

    @JsonProperty(ApiProperties.ICON_CUSTOM_EMOJI_ID)
    private String iconCustomEmojiId;
}
