package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a join request sent to a chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatjoinrequest">ChatJoinRequest</a>
 */
@Data
public class ChatJoinRequest {

    private Chat chat;

    private User from;

    @JsonProperty("user_chat_id")
    private Long userChatId;

    private Long date;

    private String bio;

    @JsonProperty(ApiProperties.INVITE_LINK)
    private ChatInviteLink inviteLink;
}
