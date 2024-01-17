package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#messageentity">MessageEntity</a>
 */
@Data
public class MessageEntity {

    private String type;

    private Integer offset;

    private Integer length;

    private String url;

    private User user;

    private String language;

    @JsonProperty(ApiProperties.CUSTOM_EMOJI_ID)
    private String customEmojiId;

}
