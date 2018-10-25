package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.TGResponce;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.webclient.TGBotWebClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.List;
import java.util.function.Consumer;

/**
 * Use this method to forward messages of any kind. On success, the sent Message is returned.
 * See <a href="ForwardMessage">https://core.telegram.org/bots/api#forwardmessage</a>
 * <p>
 * Field	            Type	            Required    Description
 * chat_id	            Integer or String	Yes	        Unique identifier for the target chat or username of the target channel (in the format @channelusername)
 * from_chat_id	        Integer or String	Yes	        Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
 * disable_notification	Boolean	            Optional	Sends the message silently. Users will receive a notification with no sound.
 * message_id	        Integer	            Yes	        Message identifier in the chat specified in from_chat_id
 **/
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForwardMessage extends TGApiMethod<TGResponce<Message>> {

    @JsonProperty(SendMethod.CHAT_ID)
    protected String chatId;

    @JsonProperty("from_chat_id")
    protected Long fromChatId;

    @JsonProperty(SendMethod.DISABLE_NOTIFICATION)
    protected Boolean disableNotification;

    @JsonProperty("message_id")
    protected Long messageId;

    public ForwardMessage(String chatId, Message message, TGBotWebClient wc) {
        super(wc);
        this.chatId = chatId;
        this.fromChatId = message.getChat().getId();
        this.messageId = message.getMessageId();
    }

    public ForwardMessage(String chatId, Long fromChatId, Long messageId, TGBotWebClient wc) {
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
    public Mono<TGResponce<Message>> send() {
        return wc.forwardMessage(this);
    }

    @Override
    public Disposable subscribe(Consumer<TGResponce<Message>> consumer) {
        return wc.forwardMessage(this).subscribe(consumer);
    }
}
