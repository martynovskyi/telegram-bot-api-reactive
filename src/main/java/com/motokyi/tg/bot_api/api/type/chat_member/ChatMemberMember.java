package com.motokyi.tg.bot_api.api.type.chat_member;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a chat member that has no additional privileges or restrictions.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#chatmembermember">ChatMemberMember</a>
 */
@Data
public class ChatMemberMember {

    private String status;

    private User user;
}
