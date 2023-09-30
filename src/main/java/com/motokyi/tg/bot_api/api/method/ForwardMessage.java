package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.ForwardMessage ForwardMessage} method with the ability
 * to self-execution and chain setter
 */
public class ForwardMessage
        extends com.motokyi.tg.bot_api.api.method.payload.ForwardMessage
        implements BotMethod<Response<Message>> {
    @JsonIgnore
    private final BotApiClient client;

    public ForwardMessage(String chatId, Message message, BotApiClient client) {
        super(chatId, message);
        this.client = client;
    }

    public ForwardMessage(String chatId, Long fromChatId, Long messageId, BotApiClient client) {
        super(chatId, fromChatId, messageId);
        this.client = client;
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.forwardMessage(this);
    }

    public ForwardMessage chatId(String chatId) {
        super.setChatId(chatId);
        return this;
    }

    public ForwardMessage fromChatId(Long fromChatId) {
        super.setFromChatId(fromChatId);
        return this;
    }


    public ForwardMessage disableNotification(Boolean disableNotification) {
        super.setDisableNotification(disableNotification);
        return this;
    }

    public ForwardMessage messageId(Long messageId) {
        super.setMessageId(messageId);
        return this;
    }
}
