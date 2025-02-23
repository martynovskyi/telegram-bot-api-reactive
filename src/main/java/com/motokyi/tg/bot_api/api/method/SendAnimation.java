package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.List;

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

    public SendAnimation businessConnectionId(String businessConnectionId) {
        super.setBusinessConnectionId(businessConnectionId);
        return this;
    }

    public SendAnimation messageThreadId(String messageThreadId) {
        super.setMessageThreadId(messageThreadId);
        return this;
    }

    public SendAnimation animation(File animationFile) {
        super.setAnimationFile(animationFile);
        return this;
    }

    public SendAnimation animation(String animationId) {
        super.setAnimation(animationId);
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

    public SendAnimation thumbnail(File thumbnailFile) {
        this.setThumbnailFile(thumbnailFile);
        return this;
    }

    public SendAnimation thumbnail(String thumbnail) {
        this.setThumbnail(thumbnail);
        return this;
    }

    public SendAnimation caption(String caption) {
        super.setCaption(caption);
        return this;
    }

    public SendAnimation parseMode(String parseMode) {
        super.setParseMode(parseMode);
        return this;
    }

    public SendAnimation captionEntities(List<MessageEntity> captionEntities) {
        super.setCaptionEntities(captionEntities);
        return this;
    }

    public SendAnimation showCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        super.setShowCaptionAboveMedia(showCaptionAboveMedia);
        return this;
    }

    public SendAnimation hasSpoiler(Boolean hasSpoiler) {
        super.setHasSpoiler(hasSpoiler);
        return this;
    }

    public SendAnimation disableNotification(Boolean disableNotification) {
        super.setDisableNotification(disableNotification);
        return this;
    }

    public SendAnimation protectContent(Boolean protectContent) {
        super.setProtectContent(protectContent);
        return this;
    }

    public SendAnimation allowPaidBroadcast(Boolean allowPaidBroadcast) {
        super.setAllowPaidBroadcast(allowPaidBroadcast);
        return this;
    }

    public SendAnimation messageEffectId(String messageEffectId) {
        super.setMessageEffectId(messageEffectId);
        return this;
    }

    public SendAnimation replyParameters(ReplyParameters replyParameters) {
        super.setReplyParameters(replyParameters);
        return this;
    }

    public SendAnimation replyMarkup(KeyboardMarkup replyMarkup) {
        super.setReplyMarkup(replyMarkup);
        return this;
    }
}
