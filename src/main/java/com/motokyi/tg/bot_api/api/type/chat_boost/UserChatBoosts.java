package com.motokyi.tg.bot_api.api.type.chat_boost;

import lombok.Data;

import java.util.List;

/**
 * This object represents a list of boosts added to a chat by a user.
 * See <a href="UserChatBoosts">https://core.telegram.org/bots/api#userchatboosts</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class UserChatBoosts {
    private List<ChatBoost> boosts;
}
