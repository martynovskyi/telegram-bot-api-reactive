package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 * See <a href="PhotoSize">https://core.telegram.org/bots/api#photosize</a>
 * <p>
 * Field	  Type    Description
 * file_id    String	Unique identifier for this file
 * width      Integer	Photo width
 * height	  Integer	Photo height
 * file_size  Integer	Optional. File size
 */
@Data
public class PhotoSize {

    @JsonProperty("file_id")
    private String fileId;

    private Integer width;

    private Integer height;

    @JsonProperty("file_size")
    private Integer fileSize;

}
