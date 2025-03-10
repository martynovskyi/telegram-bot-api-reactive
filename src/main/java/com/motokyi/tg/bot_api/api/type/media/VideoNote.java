package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#videonote">VideoNote</a>
 */
@Data
public class VideoNote {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    private Integer length;

    private Integer duration;

    private PhotoSize thumbnail;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;
}
