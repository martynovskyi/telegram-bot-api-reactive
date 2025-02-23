package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import com.motokyi.tg.bot_api.client.BotApiClient;
import java.io.File;
import java.util.List;
import reactor.core.publisher.Mono;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SendPhoto SendPhoto} method with the ability to
 * self-execution and chain setter
 */
public class SendPhoto extends com.motokyi.tg.bot_api.api.method.payload.SendPhoto
        implements BotMethod<Response<Message>> {

    @JsonIgnore private final BotApiClient client;

    public SendPhoto(String chatId, BotApiClient client) {
        super(chatId);
        this.client = client;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    public SendPhoto businessConnectionId(String businessConnectionId) {
        super.setBusinessConnectionId(businessConnectionId);
        return this;
    }

    public SendPhoto messageThreadId(String messageThreadId) {
        super.setMessageThreadId(messageThreadId);
        return this;
    }

    public SendPhoto photo(File photoFile) {
        super.setPhotoFile(photoFile);
        return this;
    }

    public SendPhoto photo(String photoId) {
        super.setPhotoId(photoId);
        return this;
    }

    public SendPhoto caption(String caption) {
        super.setCaption(caption);
        return this;
    }

    public SendPhoto parseMode(String parseMode) {
        super.setParseMode(parseMode);
        return this;
    }

    public SendPhoto captionEntities(List<MessageEntity> captionEntities) {
        super.setCaptionEntities(captionEntities);
        return this;
    }

    public SendPhoto showCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        super.setShowCaptionAboveMedia(showCaptionAboveMedia);
        return this;
    }

    public SendPhoto hasSpoiler(Boolean hasSpoiler) {
        super.setHasSpoiler(hasSpoiler);
        return this;
    }

    public SendPhoto disableNotification(Boolean disableNotification) {
        super.setDisableNotification(disableNotification);
        return this;
    }

    public SendPhoto protectContent(Boolean protectContent) {
        super.setProtectContent(protectContent);
        return this;
    }

    public SendPhoto allowPaidBroadcast(Boolean allowPaidBroadcast) {
        super.setAllowPaidBroadcast(allowPaidBroadcast);
        return this;
    }

    public SendPhoto messageEffectId(String messageEffectId) {
        super.setMessageEffectId(messageEffectId);
        return this;
    }

    public SendPhoto replyParameters(ReplyParameters replyParameters) {
        super.setReplyParameters(replyParameters);
        return this;
    }

    public SendPhoto replyMarkup(KeyboardMarkup replyMarkup) {
        super.setReplyMarkup(replyMarkup);
        return this;
    }
}
