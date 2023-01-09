package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
 * See <a href="SendAnimation">https://core.telegram.org/bots/api#sendanimation</a>
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendAnimation extends SendMethod {
    public static final String ANIMATION_ID = "animation";
    public static final String THUMB_ID = "thumb";
    public static final String DURATION = "duration";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String CAPTION = "caption";

    @JsonIgnore
    private File animationFile;

    @JsonProperty(ANIMATION_ID)
    private String animationId;

    private Integer duration;

    private Integer width;

    private Integer height;

    @JsonIgnore
    private File thumb;

    @JsonProperty(THUMB_ID)
    private String thumbId;

    private String caption;

    public SendAnimation(String chatId) {
        super(chatId);
    }
}
