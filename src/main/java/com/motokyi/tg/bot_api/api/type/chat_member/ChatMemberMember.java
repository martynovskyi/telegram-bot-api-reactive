package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a chat member that has no additional privileges or restrictions.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatmembermember">ChatMemberMember</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChatMemberMember extends ChatMember {
    private User user;

    @JsonProperty(ApiProperties.UNTIL_DATE)
    private Long untilDate;
}
