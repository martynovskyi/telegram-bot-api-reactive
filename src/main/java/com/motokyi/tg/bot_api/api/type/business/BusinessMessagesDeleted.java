package com.motokyi.tg.bot_api.api.type.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import java.util.List;
import lombok.Data;

/**
 * This object is received when messages are deleted from a connected business account.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#businessmessagesdeleted">BusinessMessagesDeleted</a>
 */
@Data
public class BusinessMessagesDeleted {

    @JsonProperty(ApiProperties.BUSINESS_CONNECTION_ID)
    private String businessConnectionId;

    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_IDS)
    private List<Long> messageIds;
}
