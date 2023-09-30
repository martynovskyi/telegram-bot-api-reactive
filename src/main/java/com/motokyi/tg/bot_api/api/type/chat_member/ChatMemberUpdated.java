package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.chat.ChatInviteLink;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object represents changes in the status of a chat member.
 * See <a href="ChatMemberUpdated">https://core.telegram.org/bots/api#chatmemberupdated</a>
 * <p>
 *
 * @version Bot API 6.9
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
