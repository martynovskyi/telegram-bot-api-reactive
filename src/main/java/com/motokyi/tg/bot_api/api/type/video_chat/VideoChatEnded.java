package com.motokyi.tg.bot_api.api.type.video_chat;

import lombok.Data;

/**
 * This object represents a service message about a video chat ended in the chat.
 * See <a href="VideoChatEnded">https://core.telegram.org/bots/api#videochatended</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class VideoChatEnded {

    private Integer duration;
}
