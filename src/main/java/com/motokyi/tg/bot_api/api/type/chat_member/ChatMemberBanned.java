package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a chat member that was banned in the chat and can't return to the chat or view chat messages.
 * See <a href="ChatMemberBanned">https://core.telegram.org/bots/api#chatmemberbanned</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ChatMemberBanned {

    private String status;

    private User user;

    @JsonProperty(ApiProperties.UNTIL_DATE)
    private Long untilDate;

}
