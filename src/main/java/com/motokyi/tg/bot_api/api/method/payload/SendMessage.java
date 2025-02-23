package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.LinkPreviewOptions;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#sendmessage">SendMessage</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessage implements SendMethod {

    @JsonProperty(ApiProperties.BUSINESS_CONNECTION_ID)
    private String businessConnectionId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    private String messageThreadId;

    private String text;

    @JsonProperty(ApiProperties.PARSE_MODE)
    private String parseMode;

    private List<MessageEntity> entities;

    @JsonProperty(ApiProperties.LINK_PREVIEW_OPTIONS)
    private LinkPreviewOptions linkPreviewOptions;

    @JsonProperty(ApiProperties.DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    @JsonProperty(ApiProperties.PROTECT_CONTENT)
    private Boolean protectContent;

    @JsonProperty(ApiProperties.ALLOW_PAID_BROADCAST)
    private Boolean allowPaidBroadcast;

    @JsonProperty(ApiProperties.MESSAGE_EFFECT_ID)
    private String messageEffectId;

    @JsonProperty(ApiProperties.REPLY_PARAMETERS)
    private ReplyParameters replyParameters;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    private KeyboardMarkup replyMarkup;

    public SendMessage(String chatId) {
        this.chatId = chatId;
    }
}
