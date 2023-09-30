package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 * See <a href="Audio">https://core.telegram.org/bots/api#audio</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class Audio {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    private Integer duration;

    private String performer;

    private String title;

    @JsonProperty(ApiProperties.FILE_NAME)
    private String fileName;

    @JsonProperty(ApiProperties.MIME_TYPE)
    private String mimeType;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;

    private PhotoSize thumbnail;
}
