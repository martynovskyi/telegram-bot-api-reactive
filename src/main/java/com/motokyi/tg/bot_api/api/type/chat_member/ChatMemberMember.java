package com.motokyi.tg.bot_api.api.type.chat_member;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a chat member that has no additional privileges or restrictions.
 * See <a href="ChatMemberMember">https://core.telegram.org/bots/api#chatmembermember</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ChatMemberMember {

    private User user;

    private String status;
}
