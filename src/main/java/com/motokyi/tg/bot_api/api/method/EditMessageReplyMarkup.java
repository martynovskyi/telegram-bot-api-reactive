package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.types.Message;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

public class EditMessageReplyMarkup
        extends com.motokyi.tg.bot_api.api.method.payload.EditMessageReplyMarkup
        implements BotMethod<Response<Message>> {

    @JsonIgnore
    private final BotApiClient client;

    public EditMessageReplyMarkup(String chatId, String messageId, BotApiClient client) {
        super(chatId, messageId);
        this.client = client;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.editMessageReplyMarkup(this);
    }

    public EditMessageReplyMarkup replyMarkup(KeyboardMarkup replyMarkup) {
        super.setReplyMarkup(replyMarkup);
        return this;
    }

    public EditMessageReplyMarkup inlineMessageId(String inlineMessageId) {
        super.setInlineMessageId(inlineMessageId);
        return this;
    }

    public EditMessageReplyMarkup messageId(String messageId) {
        super.setMessageId(messageId);
        return this;
    }

    public EditMessageReplyMarkup chatId(String chatId) {
        super.setChatId(chatId);
        return this;
    }
}
