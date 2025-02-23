package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.constant.BotConstants;
import com.motokyi.tg.bot_api.api.type.LinkPreviewOptions;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import com.motokyi.tg.bot_api.client.BotApiClient;
import java.util.List;
import reactor.core.publisher.Mono;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SendMessage SendMessage} method with the ability
 * to self-execution and chain setter
 */
public class SendMessage extends com.motokyi.tg.bot_api.api.method.payload.SendMessage
        implements BotMethod<Response<Message>> {
    @JsonIgnore private final BotApiClient client;

    public SendMessage(String chatId, BotApiClient apiClient) {
        super(chatId);
        this.client = apiClient;
    }

    public Mono<Response<Message>> send() {
        if (super.getText().length() > BotConstants.TEXT_LENGTH_LIMIT) {
            super.setText(super.getText().substring(0, BotConstants.TEXT_LENGTH_LIMIT));
        }
        return client.send(this);
    }

    public SendMessage businessConnectionId(String businessConnectionId) {
        super.setBusinessConnectionId(businessConnectionId);
        return this;
    }

    public SendMessage messageThreadId(String messageThreadId) {
        super.setMessageThreadId(messageThreadId);
        return this;
    }

    public SendMessage text(String text) {
        this.setText(text);
        return this;
    }

    public SendMessage parseMode(String parseMode) {
        super.setParseMode(parseMode);
        return this;
    }

    public SendMessage entities(List<MessageEntity> entities) {
        super.setEntities(entities);
        return this;
    }

    public SendMessage linkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        super.setLinkPreviewOptions(linkPreviewOptions);
        return this;
    }

    public SendMessage disableNotification(Boolean disableNotification) {
        super.setDisableNotification(disableNotification);
        return this;
    }

    public SendMessage protectContent(Boolean protectContent) {
        super.setProtectContent(protectContent);
        return this;
    }

    public SendMessage allowPaidBroadcast(Boolean allowPaidBroadcast) {
        super.setAllowPaidBroadcast(allowPaidBroadcast);
        return this;
    }

    public SendMessage messageEffectId(String messageEffectId) {
        super.setMessageEffectId(messageEffectId);
        return this;
    }

    public SendMessage replyParameters(ReplyParameters replyParameters) {
        super.setReplyParameters(replyParameters);
        return this;
    }

    public SendMessage replyMarkup(KeyboardMarkup replyMarkup) {
        super.setReplyMarkup(replyMarkup);
        return this;
    }
}
