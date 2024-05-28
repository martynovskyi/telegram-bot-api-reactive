package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a video file.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#video">Video</a>
 */
@Data
public class Video {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    private Integer width;

    private Integer height;

    private Integer duration;

    private PhotoSize thumbnail;

    @JsonProperty(ApiProperties.FILE_NAME)
    private String fileName;

    @JsonProperty(ApiProperties.MIME_TYPE)
    private String mimeType;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;
}
