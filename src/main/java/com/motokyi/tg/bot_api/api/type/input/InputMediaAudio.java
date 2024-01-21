package com.motokyi.tg.bot_api.api.type.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Data;

import java.util.List;

/**
 * Represents an audio file to be treated as music to be sent.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#inputmediaaudio">InputMediaAudio</a>
 */
@Data
public class InputMediaAudio {

    private String type;

    private String media;

    private String thumbnail;

    private String caption;

    @JsonProperty(ApiProperties.PARSE_MODE)
    private String parseMode;

    @JsonProperty(ApiProperties.CAPTION_ENTITIES)
    private List<MessageEntity> captionEntities;

    private Integer duration;

    private String performer;

    private String title;
}
