package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.LinkPreviewOptions;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

import java.util.List;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.EditMessageText EditMessageText}
 * method with the ability to self-execution and chain setter
 */
public class EditMessageText
        extends com.motokyi.tg.bot_api.api.method.payload.EditMessageText
        implements BotMethod<Response<Message>> {

    @JsonIgnore
    private final BotApiClient client;

    public EditMessageText(String chatId, String messageId, BotApiClient client) {
        super(chatId, messageId);
        this.client = client;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    public EditMessageText chatId(String chatId) {
        super.setChatId(chatId);
        return this;
    }

    public EditMessageText messageId(String messageId) {
        super.setMessageId(messageId);
        return this;
    }

    public EditMessageText inlineMessageId(String inlineMessageId) {
        super.setInlineMessageId(inlineMessageId);
        return this;
    }

    public EditMessageText text(String text) {
        super.setText(text);
        return this;
    }

    public EditMessageText parseMode(String parseMode) {
        super.setParseMode(parseMode);
        return this;
    }

    public EditMessageText entities(List<MessageEntity> entities) {
        super.setEntities(entities);
        return this;
    }

    public EditMessageText linkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        super.setLinkPreviewOptions(linkPreviewOptions);
        return this;
    }

    public EditMessageText replyMarkup(KeyboardMarkup replyMarkup) {
        super.setReplyMarkup(replyMarkup);
        return this;
    }
}
