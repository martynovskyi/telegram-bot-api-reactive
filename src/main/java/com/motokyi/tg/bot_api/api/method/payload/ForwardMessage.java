package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.Message;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to forward messages of any kind. On success, the sent Message is returned.
 * See <a href="ForwardMessage">https://core.telegram.org/bots/api#forwardmessage</a>
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForwardMessage {

    @JsonProperty(SendMethod.CHAT_ID)
    protected String chatId;

    @JsonProperty("from_chat_id")
    protected Long fromChatId;

    @JsonProperty(SendMethod.DISABLE_NOTIFICATION)
    protected Boolean disableNotification;

    @JsonProperty("message_id")
    protected Long messageId;

    public ForwardMessage(String chatId, Message message) {
        this.chatId = chatId;
        this.fromChatId = message.getChat().getId();
        this.messageId = message.getMessageId();
    }

    public ForwardMessage(String chatId, Long fromChatId, Long messageId) {
        this.chatId = chatId;
        this.fromChatId = fromChatId;
        this.messageId = messageId;
    }
}
