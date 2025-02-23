package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionType;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to change the chosen reactions on a message. Service messages can't be reacted
 * to. Automatically forwarded messages from a channel to its discussion group have the same
 * available reactions as messages in the channel. Returns True on success.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#setmessagereaction">setMessageReaction</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetMessageReaction {

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    private List<ReactionType> reaction;

    @JsonProperty(ApiProperties.IS_BIG)
    private Boolean isBig;

    public SetMessageReaction(String chatId, Long messageId) {
        this.chatId = chatId;
        this.messageId = messageId;
    }
}
