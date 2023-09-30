package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a chat member that owns the chat and has all administrator privileges.
 * See <a href="ChatMemberOwner">https://core.telegram.org/bots/api#chatmemberowner</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ChatMemberOwner {

    private User user;

    private String status;

    @JsonProperty(ApiProperties.IS_ANONYMOUS)
    private Boolean isAnonymous;

    @JsonProperty(ApiProperties.CUSTOM_TITLE)
    private String customTitle;
}
