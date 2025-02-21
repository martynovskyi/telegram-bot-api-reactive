package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a chat photo.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatphoto">ChatPhoto</a>
 */
@Data
public class ChatPhoto {
    @JsonProperty("small_file_id")
    private String smallFileId;

    @JsonProperty("small_file_unique_id")
    private String smallFileUniqueId;

    @JsonProperty("big_file_id")
    private String bigFileId;

    @JsonProperty("big_file_unique_id")
    private String bigFileUniqueId;
}
