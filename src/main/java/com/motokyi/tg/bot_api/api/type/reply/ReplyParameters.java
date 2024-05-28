package com.motokyi.tg.bot_api.api.type.reply;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Describes reply parameters for the message that is being sent.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#replyparameters">ReplyParameters</a>
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyParameters {

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    @JsonProperty(ApiProperties.ALLOW_SENDING_WITHOUT_REPLY)
    private Boolean allowSendingWithoutReply;

    private String quote;

    @JsonProperty(ApiProperties.QUOTE_PARSE_MODE)
    private String quoteParseMode;

    @JsonProperty(ApiProperties.QUOTE_ENTITIES)
    private List<MessageEntity> quoteEntities;

    @JsonProperty(ApiProperties.QUOTE_POSITION)
    private Integer quote_position;
}
