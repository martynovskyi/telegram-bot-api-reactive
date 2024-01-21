package com.motokyi.tg.bot_api.api.type.chat_member;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a chat member that isn't currently a member of the chat, but may join it themselves.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#chatmemberleft">ChatMemberLeft</a>
 */

@Data
public class ChatMemberLeft {

    private String status;

    private User user;
}
