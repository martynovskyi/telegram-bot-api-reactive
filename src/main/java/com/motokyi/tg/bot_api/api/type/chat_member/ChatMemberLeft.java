package com.motokyi.tg.bot_api.api.type.chat_member;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a chat member that isn't currently a member of the chat, but may join it themselves.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatmemberleft">ChatMemberLeft</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChatMemberLeft extends ChatMember {
    private User user;
}
