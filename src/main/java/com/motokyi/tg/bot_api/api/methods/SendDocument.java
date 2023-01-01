package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.Message;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.client.BotClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.function.Consumer;

/**
 * Use this method to send general files. On success, the sent Message is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
 * See <a href="SendDocument">https://core.telegram.org/bots/api#senddocument</a>
 **/
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendDocument extends SendMethod<Response<Message>> {
    public static final String DOCUMENT_ID = "document";


    @JsonIgnore
    private File documentFile;

    @JsonProperty(DOCUMENT_ID)
    private String documentId;

    public SendDocument(String chatId, BotClient rt) {
        super(chatId, rt);
    }

    public SendDocument(Long chatId, BotClient rt) {
        super(String.valueOf(chatId), rt);
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return client.send(this).subscribe(consumer);
    }


    public SendDocument setDocument(File documentFile) {
        this.documentFile = documentFile;
        return this;
    }

    public SendDocument setDocument(String documentId) {
        this.documentId = documentId;
        return this;
    }

    public SendDocument setParseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendDocument setDisableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendDocument setDisableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendDocument setReplyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendDocument setReplyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
