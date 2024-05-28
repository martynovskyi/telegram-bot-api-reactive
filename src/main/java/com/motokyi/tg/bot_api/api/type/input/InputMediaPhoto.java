package com.motokyi.tg.bot_api.api.type.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Data;

import java.util.List;

/**
 * Represents a photo to be sent.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#inputmediaphoto">InputMediaPhoto</a>
 */
@Data
public class InputMediaPhoto {

    private String type;

    private String media;

    private String caption;

    @JsonProperty(ApiProperties.PARSE_MODE)
    private String parseMode;

    @JsonProperty(ApiProperties.CAPTION_ENTITIES)
    private List<MessageEntity> captionEntities;

    @JsonProperty(ApiProperties.SHOW_CAPTION_ABOVE_MEDIA)
    private String showCaptionAboveMedia;

    @JsonProperty(ApiProperties.HAS_SPOILER)
    private Boolean hasSpoiler;
}
