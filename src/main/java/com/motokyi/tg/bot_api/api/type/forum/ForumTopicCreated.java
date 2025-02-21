package com.motokyi.tg.bot_api.api.type.forum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a service message about a new forum topic created in the chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#forumtopiccreated">ForumTopicCreated</a>
 */
@Data
public class ForumTopicCreated {

    private String name;

    @JsonProperty(ApiProperties.ICON_COLOR)
    private Integer iconColor;

    @JsonProperty(ApiProperties.ICON_CUSTOM_EMOJI_ID)
    private String iconCustomEmojiId;
}
