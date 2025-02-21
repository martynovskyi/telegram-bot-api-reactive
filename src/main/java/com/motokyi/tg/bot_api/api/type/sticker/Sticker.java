package com.motokyi.tg.bot_api.api.type.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.File;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import lombok.Data;

/**
 * This object represents a sticker.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#sticker">Sticker</a>
 */
@Data
public class Sticker {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    private String type;

    private Integer width;

    private Integer height;

    @JsonProperty("is_animated")
    private Boolean isAnimated;

    @JsonProperty("is_video")
    private Boolean isVideo;

    private PhotoSize thumbnail;

    private String emoji;

    @JsonProperty("set_name")
    private String setName;

    @JsonProperty("premium_animation")
    private File premiumAnimation;

    @JsonProperty("mask_position")
    private MaskPosition maskPosition;

    @JsonProperty(ApiProperties.CUSTOM_EMOJI_ID)
    private String customEmojiId;

    @JsonProperty("needs_repainting")
    private Boolean needsRepainting;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;
}
