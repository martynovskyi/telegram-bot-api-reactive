package com.motokyi.tg.bot_api.api.type.forum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a service message about a new forum topic created in the chat.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#forumtopiccreated">ForumTopicCreated</a>
 */
@Data
public class ForumTopicCreated {

    private String name;

    @JsonProperty("icon_color")
    private Integer iconColor;

    @JsonProperty(ApiProperties.ICON_CUSTOM_EMOJI_ID)
    private String iconCustomEmojiId;
}
