package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a chat member that owns the chat and has all administrator privileges.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatmemberowner">ChatMemberOwner</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChatMemberOwner extends ChatMember {

    private User user;

    @JsonProperty(ApiProperties.IS_ANONYMOUS)
    private Boolean isAnonymous;

    @JsonProperty(ApiProperties.CUSTOM_TITLE)
    private String customTitle;
}
