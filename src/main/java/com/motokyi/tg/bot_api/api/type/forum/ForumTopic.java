package com.motokyi.tg.bot_api.api.type.forum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a forum topic.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#forumtopic">ForumTopic</a>
 */
@Data
public class ForumTopic {

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    private Long messageThreadId;

    private String name;

    @JsonProperty(ApiProperties.ICON_COLOR)
    private Integer iconColor;

    @JsonProperty(ApiProperties.ICON_CUSTOM_EMOJI_ID)
    private String iconCustomEmojiId;
}
