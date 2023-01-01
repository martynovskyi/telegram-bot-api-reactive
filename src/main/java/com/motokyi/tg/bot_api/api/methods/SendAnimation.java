package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.Message;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.function.Consumer;

/**
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
 * See <a href="SendAnimation">https://core.telegram.org/bots/api#sendanimation</a>
 **/
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendAnimation extends SendMethod<Response<Message>> {

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

    public SendAnimation(String chatId, BotApiClient apiClient) {
        super(chatId, apiClient);
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return client.send(this).subscribe(consumer);
    }

    public SendAnimation setAnimation(File animationFile) {
        this.animationFile = animationFile;
        return this;
    }

    public SendAnimation setAnimation(String animationId) {
        this.animationId = animationId;
        return this;
    }

    public SendAnimation setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SendAnimation setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public SendAnimation setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public SendAnimation setThumb(File thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendAnimation setThumbId(String thumbId) {
        this.thumbId = thumbId;
        return this;
    }

    public SendAnimation setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendAnimation setParseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendAnimation setDisableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendAnimation setDisableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendAnimation setReplyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendAnimation setReplyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
