package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a voice note.
 * See <a href="Voice">https://core.telegram.org/bots/api#voice</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class Voice {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    private Integer duration;

    @JsonProperty(ApiProperties.MIME_TYPE)
    private String mimeType;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;
}
