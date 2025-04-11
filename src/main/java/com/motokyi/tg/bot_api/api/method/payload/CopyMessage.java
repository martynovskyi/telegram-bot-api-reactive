package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to copy messages of any kind. Service messages, paid media messages, giveaway
 * messages, giveaway winners messages, and invoice messages can't be copied. A quiz poll can be
 * copied only if the value of the field correct_option_id is known to the bot. The method is
 * analogous to the method forwardMessage, but the copied message doesn't have a link to the
 * original message. Returns the MessageId of the sent message on success.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#copymessage">copyMessage</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CopyMessage {
    @JsonProperty(ApiProperties.CHAT_ID)
    protected String chatId;

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    protected Long messageThreadId;

    @JsonProperty(ApiProperties.FROM_CHAT_ID)
    protected String fromChatId;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    protected Long messageId;

    @JsonProperty(ApiProperties.VIDEO_START_TIMESTAMP)
    protected Long videoStartTimestamp;

    protected String caption;

    @JsonProperty(ApiProperties.PARSE_MODE)
    protected String parseMode;

    @JsonProperty(ApiProperties.CAPTION_ENTITIES)
    protected List<MessageEntity> captionEntities;

    @JsonProperty(ApiProperties.SHOW_CAPTION_ABOVE_MEDIA)
    protected Boolean showCaptionAboveMedia;

    @JsonProperty(ApiProperties.DISABLE_NOTIFICATION)
    protected Boolean disableNotification;

    @JsonProperty(ApiProperties.PROTECT_CONTENT)
    protected Boolean protectContent;

    @JsonProperty(ApiProperties.ALLOW_PAID_BROADCAST)
    protected Boolean allowPaidBroadcast;

    @JsonProperty(ApiProperties.REPLY_PARAMETERS)
    protected ReplyParameters replyParameters;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    protected KeyboardMarkup replyMarkup;

    public CopyMessage(String chatId, String fromChatId, Long messageId) {
        this.chatId = chatId;
        this.fromChatId = fromChatId;
        this.messageId = messageId;
    }
}
