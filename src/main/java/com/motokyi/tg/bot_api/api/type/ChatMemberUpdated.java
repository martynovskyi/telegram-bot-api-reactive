package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents changes in the status of a chat member.
 * See <a href="ChatMemberUpdated">https://core.telegram.org/bots/api#chatmemberupdated</a>
 * <p>
 */
@Data
public class ChatMemberUpdated {
    private Chat chat;

    private User from;

    private Integer date;

    @JsonProperty("old_chat_member")
    private ChatMember oldChatMember;

    @JsonProperty("new_chat_member")
    private ChatMember newChatMember;

    @JsonProperty("invite_link")
    private ChatInviteLink inviteLink;
}