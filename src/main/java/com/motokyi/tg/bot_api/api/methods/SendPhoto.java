package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.Message;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.function.Consumer;

/**
 * Use this method to send photos. On success, the sent Message is returned.
 * See <a href="SendPhoto">https://core.telegram.org/bots/api#audio</a>
 */

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendPhoto extends SendMethod<Response<Message>> {
    public static final String PHOTO_ID = "photo";

    @JsonIgnore
    private File photoFile;

    @JsonProperty(PHOTO_ID)
    private String photoId;

    public SendPhoto(String chatId, BotApiClient apiClient) {
        super(chatId, apiClient);
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return client.send(this).subscribe(consumer);
    }

    public SendPhoto setPhoto(File photoFile) {
        this.photoFile = photoFile;
        return this;
    }

    public SendPhoto setPhoto(String photoId) {
        this.photoId = photoId;
        return this;
    }

    public SendPhoto setParseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendPhoto setDisableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendPhoto setDisableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendPhoto setReplyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendPhoto setReplyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
