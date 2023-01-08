package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.motokyi.tg.bot_api.api.types.Message;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 * See <a href="SendMessage">https://core.telegram.org/bots/api#sendmessage</a>
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessage extends SendMethod<Response<Message>> {
    public static final String TEXT = "text";
    public static final int TEXT_LENGTH_LIMIT = 4096;

    private String text;

    public SendMessage(String chatId, BotApiClient apiClient) {
        super(chatId, apiClient);
    }

    @Override
    public Mono<Response<Message>> send() {
        if (text.length() > TEXT_LENGTH_LIMIT) {
            this.text = text.substring(0, TEXT_LENGTH_LIMIT);
        }
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return send().subscribe(consumer);
    }

    public SendMessage setText(String text) {
        this.text = text;
        return this;
    }

    public SendMessage setParseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendMessage setDisableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendMessage setDisableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendMessage setReplyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendMessage setReplyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
