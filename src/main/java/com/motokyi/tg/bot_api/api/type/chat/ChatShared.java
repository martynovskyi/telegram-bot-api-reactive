package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object contains information about the chat whose identifier
 * was shared with the bot using a KeyboardButtonRequestChat button.
 * See <a href="ChatShared">https://core.telegram.org/bots/api#chatshared</a>
 * <p>
 *
 * @version Bot API 6.9
 */

@Data
public class ChatShared {

    @JsonProperty(ApiProperties.REQUEST_ID)
    private Long requestId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private Long chatId;
}
