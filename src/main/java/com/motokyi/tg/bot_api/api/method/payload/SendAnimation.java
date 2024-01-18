package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

/**
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound).
 * On success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in size,
 * this limit may be changed in the future.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#sendanimation">SendAnimation</a>
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendAnimation extends SendMethod {
    @JsonIgnore
    private File animationFile;

    @JsonProperty(ApiProperties.ANIMATION)
    private String animation;

    private Integer duration;

    private Integer width;

    private Integer height;

    @JsonIgnore
    private File thumbnailFile;

    @JsonProperty(ApiProperties.THUMBNAIL)
    private String thumbnail;

    private String caption;

    @JsonProperty(ApiProperties.CAPTION_ENTITIES)
    private List<MessageEntity> captionEntities;

    @JsonProperty(ApiProperties.HAS_SPOILER)
    private Boolean hasSpoiler;

    public SendAnimation(@NotNull String chatId) {
        super(chatId);
    }
}
