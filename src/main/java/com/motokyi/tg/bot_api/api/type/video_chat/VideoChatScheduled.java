package com.motokyi.tg.bot_api.api.type.video_chat;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a service message about a video chat scheduled in the chat.
 * See <a href="VideoChatScheduled">https://core.telegram.org/bots/api#videochatscheduled</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class VideoChatScheduled {

    @JsonProperty("start_date")
    private Long startDate;
}
