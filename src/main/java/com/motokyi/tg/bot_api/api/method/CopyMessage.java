package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.message.MessageId;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import com.motokyi.tg.bot_api.client.BotApiClient;
import java.util.List;
import reactor.core.publisher.Mono;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.CopyMessage CopyMessage} method with the ability
 * to self-execution and chain setter
 */
public class CopyMessage extends com.motokyi.tg.bot_api.api.method.payload.CopyMessage
        implements BotMethod<Response<MessageId>> {
    @JsonIgnore private final BotApiClient client;

    public CopyMessage(String chatId, String fromChatId, Long messageId, BotApiClient client) {
        super(chatId, fromChatId, messageId);
        this.client = client;
    }

    @Override
    public Mono<Response<MessageId>> send() {
        return client.copyMessage(this);
    }

    public CopyMessage messageThreadId(Long messageThreadId) {
        super.messageThreadId = messageThreadId;
        return this;
    }

    public CopyMessage videoStartTimestamp(Long videoStartTimestamp) {
        super.videoStartTimestamp = videoStartTimestamp;
        return this;
    }

    public CopyMessage caption(String caption) {
        super.caption = caption;
        return this;
    }

    public CopyMessage parseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public CopyMessage captionEntities(List<MessageEntity> captionEntities) {
        super.captionEntities = captionEntities;
        return this;
    }

    public CopyMessage showCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        super.showCaptionAboveMedia = showCaptionAboveMedia;
        return this;
    }

    public CopyMessage disableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public CopyMessage protectContent(Boolean protectContent) {
        super.protectContent = protectContent;
        return this;
    }

    public CopyMessage allowPaidBroadcast(Boolean allowPaidBroadcast) {
        super.allowPaidBroadcast = allowPaidBroadcast;
        return this;
    }

    public CopyMessage replyParameters(ReplyParameters replyParameters) {
        super.replyParameters = replyParameters;
        return this;
    }

    public CopyMessage replyParameters(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
