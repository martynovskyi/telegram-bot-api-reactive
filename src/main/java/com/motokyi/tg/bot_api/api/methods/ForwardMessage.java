package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.Message;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.client.BotClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * Use this method to forward messages of any kind. On success, the sent Message is returned.
 * See <a href="ForwardMessage">https://core.telegram.org/bots/api#forwardmessage</a>
 **/
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForwardMessage extends BotMethod<Response<Message>> {

    @JsonProperty(SendMethod.CHAT_ID)
    protected String chatId;

    @JsonProperty("from_chat_id")
    protected Long fromChatId;

    @JsonProperty(SendMethod.DISABLE_NOTIFICATION)
    protected Boolean disableNotification;

    @JsonProperty("message_id")
    protected Long messageId;

    public ForwardMessage(String chatId, Message message, BotClient wc) {
        super(wc);
        this.chatId = chatId;
        this.fromChatId = message.getChat().getId();
        this.messageId = message.getMessageId();
    }

    public ForwardMessage(String chatId, Long fromChatId, Long messageId, BotClient wc) {
        super(wc);
        this.chatId = chatId;
        this.fromChatId = fromChatId;
        this.messageId = messageId;
    }

    public ForwardMessage setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    public ForwardMessage setFromChatId(Long fromChatId) {
        this.fromChatId = fromChatId;
        return this;
    }

    public ForwardMessage setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public ForwardMessage setMessageId(Long messageId) {
        this.messageId = messageId;
        return this;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.forwardMessage(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return client.forwardMessage(this).subscribe(consumer);
    }
}
