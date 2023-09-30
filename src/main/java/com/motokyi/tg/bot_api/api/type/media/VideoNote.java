package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 * See <a href="VideoNote">https://core.telegram.org/bots/api#videonote</a>
 * <p>
 *
 * @version Bot API 6.9
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
