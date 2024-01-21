package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.chat.ChatInviteLink;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object represents changes in the status of a chat member.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#chatmemberupdated">ChatMemberUpdated</a>
 */
@Data
public class ChatMemberUpdated {
    private Chat chat;

    private User from;

    private Long date;

    @JsonProperty("old_chat_member")
    private ChatMember oldChatMember;

    @JsonProperty("new_chat_member")
    private ChatMember newChatMember;

    @JsonProperty(ApiProperties.INVITE_LINK)
    private ChatInviteLink inviteLink;

    @JsonProperty("via_chat_folder_invite_link")
    private Boolean viaChatFolderInviteLink;
}
