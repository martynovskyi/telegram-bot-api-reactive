package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files).
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#document">Document</a>
 */
@Data
public class Document {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    private PhotoSize thumbnail;

    @JsonProperty(ApiProperties.FILE_NAME)
    private String fileName;

    @JsonProperty(ApiProperties.MIME_TYPE)
    private String mimeType;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;
}
