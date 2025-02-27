package com.motokyi.tg.bot_api.api.type.video_chat;

import lombok.Data;

/**
 * This object represents a service message about a video chat ended in the chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#videochatended">VideoChatEnded</a>
 */
@Data
public class VideoChatEnded {

    private Integer duration;
}
