package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.Message;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to forward messages of any kind. On success, the sent Message is returned.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#forwardmessage">forwardMessage</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForwardMessage {

    @JsonProperty(ApiProperties.CHAT_ID)
    protected String chatId;

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    protected Long messageThreadId;

    @JsonProperty(ApiProperties.FROM_CHAT_ID)
    protected Long fromChatId;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    protected Long messageId;

    @JsonProperty(ApiProperties.VIDEO_START_TIMESTAMP)
    protected Long videoStartTimestamp;

    @JsonProperty(ApiProperties.DISABLE_NOTIFICATION)
    protected Boolean disableNotification;

    @JsonProperty(ApiProperties.PROTECT_CONTENT)
    protected Boolean protectContent;

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
