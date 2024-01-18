package com.motokyi.tg.bot_api.api.type.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Data;

import java.util.List;

/**
 * Describes reply parameters for the message that is being sent.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#replyparameters">ReplyParameters</a>
 */
@Data
public class ReplyParameters {

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    @JsonProperty(ApiProperties.ALLOW_SENDING_WITHOUT_REPLY)
    private Boolean allowSendingWithoutReply;

    private String quote;

    @JsonProperty(ApiProperties.QUOTE_PARSE_MODE)
    private Boolean quoteParseMode;

    @JsonProperty(ApiProperties.QUOTE_ENTITIES)
    private List<MessageEntity> quoteEntities;

    @JsonProperty(ApiProperties.QUOTE_POSITION)
    private Integer quote_position;
}
