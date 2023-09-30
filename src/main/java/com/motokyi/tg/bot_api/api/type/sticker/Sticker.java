package com.motokyi.tg.bot_api.api.type.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import lombok.Data;

/**
 * This object represents a sticker.
 * See <a href="Sticker">https://core.telegram.org/bots/api#sticker</a>
 * <p>
 * Field	        Type        Description
 * file_id	        String	        Unique identifier for this file
 * width	        Integer	        Sticker width
 * height	        Integer	        Sticker height
 * thumb	        PhotoSize	    Optional. Sticker thumbnail in the .webp or .jpg format
 * emoji	        String	        Optional. Emoji associated with the sticker
 * set_name	        String	        Optional. Name of the sticker set to which the sticker belongs
 * mask_position	MaskPosition	Optional. For mask stickers, the position where the mask should be placed
 * file_size	    Integer	        Optional. File size
 */
@Data
public class Sticker {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    private Integer width;

    private Integer height;

    private PhotoSize thumb;

    private String emoji;

    @JsonProperty("set_name")
    private String setName;

    @JsonProperty("mask_position")
    private MaskPosition naskPosition;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;

}
