package com.motokyi.tg.bot_api.api.type;

import com.motokyi.tg.bot_api.api.type.chat.Chat;
import lombok.Data;

/**
 * This object represents a story.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#story">Story</a>
 */
@Data
public class Story {
    private Long id;
    private Chat chat;
}
