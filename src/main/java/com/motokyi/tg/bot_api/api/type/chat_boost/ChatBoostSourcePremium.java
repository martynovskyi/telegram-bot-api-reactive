package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium subscription to another user.
 * See <a href="ChatBoostSourcePremium">https://core.telegram.org/bots/api#chatboostsourcepremium</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChatBoostSourcePremium extends ChatBoostSource {
    private User user;
}
