package com.motokyi.tg.bot_api.api.type.chat_member;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a chat member that isn't currently a member of the chat, but may join it themselves.
 * See <a href="ChatMemberLeft">https://core.telegram.org/bots/api#chatmemberleft</a>
 * <p>
 *
 * @version Bot API 6.9
 */

@Data
public class ChatMemberLeft {

    private String status;

    private User user;
}
