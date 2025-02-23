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
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SendDocument SendDocument} method with the ability
 * to self-execution and chain setter
 */
public class SendDocument
        extends com.motokyi.tg.bot_api.api.method.payload.SendDocument
        implements BotMethod<Response<Message>> {
    @JsonIgnore
    private final BotApiClient client;

    public SendDocument(String chatId, BotApiClient client) {
        super(chatId);
        this.client = client;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    public SendDocument businessConnectionId(String businessConnectionId) {
        super.setBusinessConnectionId(businessConnectionId);
        return this;
    }

    public SendDocument messageThreadId(String messageThreadId) {
        super.setMessageThreadId(messageThreadId);
        return this;
    }

    public SendDocument document(File documentFile) {
        this.setDocumentFile(documentFile);
        return this;
    }

    public SendDocument document(String documentId) {
        this.setDocumentId(documentId);
        return this;
    }
    public SendDocument thumbnail(File thumbnail) {
        super.setThumbnailFile(thumbnail);
        return this;
    }

    public SendDocument thumbnail(String thumbnail) {
        super.setThumbnail(thumbnail);
        return this;
    }


    public SendDocument caption(String caption) {
        super.setCaption(caption);
        return this;
    }

    public SendDocument parseMode(String parseMode) {
        super.setParseMode(parseMode);
        return this;
    }

    public SendDocument captionEntities(List<MessageEntity> captionEntities) {
        super.setCaptionEntities(captionEntities);
        return this;
    }

    public SendDocument disableContentTypeDetection(Boolean disableContentTypeDetection) {
        super.setDisableContentTypeDetection(disableContentTypeDetection);
        return this;
    }

    public SendDocument disableNotification(Boolean disableNotification) {
        super.setDisableNotification(disableNotification);
        return this;
    }

    public SendDocument protectContent(Boolean protectContent) {
        super.setProtectContent(protectContent);
        return this;
    }

    public SendDocument allowPaidBroadcast(Boolean allowPaidBroadcast) {
        super.setAllowPaidBroadcast(allowPaidBroadcast);
        return this;
    }

    public SendDocument messageEffectId(String messageEffectId) {
        super.setMessageEffectId(messageEffectId);
        return this;
    }

    public SendDocument replyParameters(ReplyParameters replyParameters) {
        super.setReplyParameters(replyParameters);
        return this;
    }

    public SendDocument replyMarkup(KeyboardMarkup replyMarkup) {
        super.setReplyMarkup(replyMarkup);
        return this;
    }
}
