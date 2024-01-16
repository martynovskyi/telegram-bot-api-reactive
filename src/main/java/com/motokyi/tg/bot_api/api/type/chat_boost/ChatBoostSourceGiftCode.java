package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The boost was obtained by the creation of Telegram Premium gift codes to boost a chat.
 * Each such code boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.
 * See <a href="ChatBoostSourceGiftCode">https://core.telegram.org/bots/api#chatboostsourcegiftcode</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChatBoostSourceGiftCode extends ChatBoostSource {
    private User user;
}
