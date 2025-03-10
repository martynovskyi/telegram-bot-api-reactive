package com.motokyi.tg.bot_api.api.type.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import java.util.List;
import lombok.Data;

/**
 * Represents a general file to be sent.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#inputmediadocument">InputMediaDocument</a>
 */
@Data
public class InputMediaDocument {

    private String type;

    private String media;

    private String thumbnail;

    private String caption;

    @JsonProperty(ApiProperties.PARSE_MODE)
    private String parseMode;

    @JsonProperty(ApiProperties.CAPTION_ENTITIES)
    private List<MessageEntity> captionEntities;

    @JsonProperty("disable_content_type_detection")
    private Boolean disableContentTypeDetection;
}
