package com.motokyi.tg.bot_api.api.type.chat_boost;

import java.util.List;
import lombok.Data;

/**
 * This object represents a list of boosts added to a chat by a user.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#userchatboosts">UserChatBoosts</a>
 */
@Data
public class UserChatBoosts {
    private List<ChatBoost> boosts;
}
