package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

import java.io.File;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SendAnimation SendAnimation} method with the ability
 * to self-execution and chain setter
 */
public class SendAnimation
        extends com.motokyi.tg.bot_api.api.method.payload.SendAnimation
        implements BotMethod<Response<Message>> {
    @JsonIgnore
    private final BotApiClient client;

    public SendAnimation(String chatId, BotApiClient client) {
        super(chatId);
        this.client = client;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    public SendAnimation animation(File animationFile) {
        this.setAnimationFile(animationFile);
        return this;
    }

    public SendAnimation animation(String animationId) {
        this.setAnimationId(animationId);
        return this;
    }

    public SendAnimation duration(Integer duration) {
        this.setDuration(duration);
        return this;
    }

    public SendAnimation width(Integer width) {
        this.setWidth(width);
        return this;
    }

    public SendAnimation height(Integer height) {
        this.setHeight(height);
        return this;
    }

    public SendAnimation thumb(File thumb) {
        this.setThumb(thumb);
        return this;
    }

    public SendAnimation thumbId(String thumbId) {
        this.setThumbId(thumbId);
        return this;
    }

    public SendAnimation caption(String caption) {
        this.setCaption(caption);
        return this;
    }

    public SendAnimation parseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendAnimation disableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendAnimation disableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendAnimation replyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendAnimation replyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
