package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 * See <a href="PhotoSize">https://core.telegram.org/bots/api#photosize</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class PhotoSize {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    private Integer width;

    private Integer height;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;
}
