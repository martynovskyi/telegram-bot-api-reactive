package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium subscription to another user.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#chatboostsourcepremium">ChatBoostSourcePremium</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChatBoostSourcePremium extends ChatBoostSource {
    private User user;
}
