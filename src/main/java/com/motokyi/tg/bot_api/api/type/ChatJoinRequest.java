package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents a join request sent to a chat.
 * <p>
 * See <a href="ChatJoinRequest">https://core.telegram.org/bots/api#chatjoinrequest</a>
 * <p>
 * Bot API 6.4
 */
@Data
public class ChatJoinRequest {

    private Chat chat;

    private User from;

    private Integer date;

    private String bio;

    @JsonProperty("invite_link")
    private ChatInviteLink inviteLink;
}
