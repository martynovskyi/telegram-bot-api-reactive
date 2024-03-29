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
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SendPhoto SendPhoto} method with the ability to
 * self-execution and chain setter
 */
public class SendPhoto
        extends com.motokyi.tg.bot_api.api.method.payload.SendPhoto
        implements BotMethod<Response<Message>> {

    @JsonIgnore
    private final BotApiClient client;

    public SendPhoto(String chatId, BotApiClient client) {
        super(chatId);
        this.client = client;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    public SendPhoto photo(File photoFile) {
        super.setPhotoFile(photoFile);
        return this;
    }

    public SendPhoto photo(String photoId) {
        super.setPhotoId(photoId);
        return this;
    }

    public SendPhoto parseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendPhoto disableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendPhoto replyParameters(ReplyParameters replyParameters) {
        super.replyParameters = replyParameters;
        return this;
    }

    public SendPhoto replyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
