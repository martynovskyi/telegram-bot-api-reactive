package com.motokyi.tg.bot_api.api.type.chat_boost;

import lombok.Data;

import java.util.List;

/**
 * This object represents a list of boosts added to a chat by a user.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#userchatboosts">UserChatBoosts</a>
 */
@Data
public class UserChatBoosts {
    private List<ChatBoost> boosts;
}
