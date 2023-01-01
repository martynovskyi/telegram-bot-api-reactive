package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.Message;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * Use this method to edit only the reply markup of messages.
 * On success, if the edited message is not an inline message, the edited Message is returned, otherwise True is returned.
 * See <a href="EditMessageReplyMarkup">https://core.telegram.org/bots/api#editmessagereplymarkup</a>
 **/
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageReplyMarkup extends BotMethod<Response<Message>> {
    @JsonProperty(SendMethod.CHAT_ID)
    private String chatId;

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("inline_message_id")
    private String inlineMessageId;

    @JsonProperty(SendMethod.REPLY_MARKUP)
    private KeyboardMarkup replyMarkup;

    public EditMessageReplyMarkup(String chatId, String messageId, BotApiClient client) {
        super(client);
        this.chatId = chatId;
        this.messageId = messageId;
    }

    public EditMessageReplyMarkup setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
        return this;
    }

    public EditMessageReplyMarkup setReplyMarkup(KeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.editMessageReplyMarkup(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return client.editMessageReplyMarkup(this).subscribe(consumer);
    }
}
