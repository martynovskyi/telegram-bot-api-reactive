package com.motokyi.tg.bot_api.api.type.message.origin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The message was originally sent on behalf of a chat to a group chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#messageoriginchat">MessageOriginChat</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageOriginChat extends MessageOrigin {

    @JsonProperty(ApiProperties.SENDER_CHAT)
    private Chat senderChat;

    @JsonProperty(ApiProperties.AUTHOR_SIGNATURE)
    private String authorSignature;
}
