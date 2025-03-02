package com.motokyi.tg.bot_api.api.type.reply;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Describes reply parameters for the message that is being sent.
 *
 * @version Bot API 8.3
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

    public static ReplyParameters ofMessageId(@NotNull Long messageId) {
        ReplyParameters replyParameters = new ReplyParameters();
        replyParameters.setMessageId(messageId);
        return replyParameters;
    }
}
