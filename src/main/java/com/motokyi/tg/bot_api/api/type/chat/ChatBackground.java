package com.motokyi.tg.bot_api.api.type.chat;

import com.motokyi.tg.bot_api.api.type.background.BackgroundType;
import lombok.Data;

/**
 * This object represents a chat background.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatbackground">ChatBackground</a>
 */

@Data
public class ChatBackground {
    private BackgroundType type;
}
