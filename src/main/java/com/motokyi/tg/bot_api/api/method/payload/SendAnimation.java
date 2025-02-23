package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
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
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#sendanimation">SendAnimation</a>
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendAnimation implements SendMethod {

    @JsonProperty(ApiProperties.BUSINESS_CONNECTION_ID)
    private String businessConnectionId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    private String messageThreadId;

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

    @JsonProperty(ApiProperties.PARSE_MODE)
    private String parseMode;

    @JsonProperty(ApiProperties.CAPTION_ENTITIES)
    private List<MessageEntity> captionEntities;

    @JsonProperty(ApiProperties.SHOW_CAPTION_ABOVE_MEDIA)
    private Boolean showCaptionAboveMedia;

    @JsonProperty(ApiProperties.HAS_SPOILER)
    private Boolean hasSpoiler;

    @JsonProperty(ApiProperties.DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    @JsonProperty(ApiProperties.PROTECT_CONTENT)
    private Boolean protectContent;

    @JsonProperty(ApiProperties.ALLOW_PAID_BROADCAST)
    private Boolean allowPaidBroadcast;

    @JsonProperty(ApiProperties.MESSAGE_EFFECT_ID)
    private String messageEffectId;

    @JsonProperty(ApiProperties.REPLY_PARAMETERS)
    private ReplyParameters replyParameters;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    private KeyboardMarkup replyMarkup;

    public SendAnimation(@NotNull String chatId) {
        this.chatId = chatId;
    }
}
