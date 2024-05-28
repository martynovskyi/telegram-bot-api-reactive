package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.motokyi.tg.bot_api.api.type.chat.Chat;
import lombok.Data;

/**
 * This object represents a boost added to a chat or changed.
 * <p>
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#chatboostupdated">ChatBoostUpdated</a>
 */
@Data
public class ChatBoostUpdated {

    private Chat chat;

    private ChatBoost boost;
}
