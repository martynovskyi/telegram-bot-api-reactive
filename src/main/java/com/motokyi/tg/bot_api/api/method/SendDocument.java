package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

import java.io.File;

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

    public SendDocument document(File documentFile) {
        this.setDocumentFile(documentFile);
        return this;
    }

    public SendDocument document(String documentId) {
        this.setDocumentId(documentId);
        return this;
    }

    public SendDocument parseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendDocument disableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendDocument replyParameters(ReplyParameters replyParameters) {
        super.replyParameters = replyParameters;
        return this;
    }

    public SendDocument replyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
