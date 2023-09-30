package com.motokyi.tg.bot_api.api.type.forum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a forum topic.
 * <p>
 * See <a href="ForumTopic">https://core.telegram.org/bots/api#forumtopic</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ForumTopic {

    @JsonProperty("message_thread_id")
    private Long messageThreadId;

    private String name;

    @JsonProperty(ApiProperties.ICON_COLOR)
    private Integer iconColor;

    @JsonProperty(ApiProperties.ICON_CUSTOM_EMOJI_ID)
    private String iconCustomEmojiId;
}