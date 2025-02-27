package com.motokyi.tg.bot_api.api.type.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Describes the connection of the bot with a business account.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#businessconnection">BusinessConnection</a>
 */
@Data
public class BusinessConnection {
    private String id;

    private User user;

    @JsonProperty(ApiProperties.USER_CHAT_ID)
    private Long userChatId;

    private Long date;

    @JsonProperty(ApiProperties.CAN_REPLY)
    private Boolean canReply;

    @JsonProperty(ApiProperties.IS_ENABLED)
    private Boolean isEnabled;
}
