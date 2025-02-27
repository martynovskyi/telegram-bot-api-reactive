package com.motokyi.tg.bot_api.api.type.video_chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a service message about a video chat scheduled in the chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#videochatscheduled">VideoChatScheduled</a>
 */
@Data
public class VideoChatScheduled {

    @JsonProperty("start_date")
    private Long startDate;
}
