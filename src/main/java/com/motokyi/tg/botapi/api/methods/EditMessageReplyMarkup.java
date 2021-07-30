package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.botapi.webclient.BotClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

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

    public EditMessageReplyMarkup(String chatId, String messageId, BotClient client) {
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
