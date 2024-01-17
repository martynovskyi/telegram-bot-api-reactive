package com.motokyi.tg.bot_api.api.type.message.origin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The message was originally sent to a channel chat.
 * <p>
 * See <a href="MessageOriginChannel">https://core.telegram.org/bots/api#messageoriginchannel</a>
 * <p>
 *
 * @version Bot API 7.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageOriginChannel extends MessageOrigin {

    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    @JsonProperty(ApiProperties.AUTHOR_SIGNATURE)
    private String authorSignature;

}