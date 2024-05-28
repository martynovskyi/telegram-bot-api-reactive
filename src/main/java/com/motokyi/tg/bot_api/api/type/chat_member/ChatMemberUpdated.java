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
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#chatmemberupdated">ChatMemberUpdated</a>
 */
@Data
public class ChatMemberUpdated {
    private Chat chat;

    private User from;

    private Long date;

    @JsonProperty(ApiProperties.OLD_CHAT_MEMBER)
    private ChatMember oldChatMember;

    @JsonProperty(ApiProperties.NEW_CHAT_MEMBER)
    private ChatMember newChatMember;

    @JsonProperty(ApiProperties.INVITE_LINK)
    private ChatInviteLink inviteLink;

    @JsonProperty(ApiProperties.VIA_JOIN_REQUEST)
    private Boolean viaJoinRequest;

    @JsonProperty(ApiProperties.VIA_CHAT_FOLDER_INVITE_LINK)
    private Boolean viaChatFolderInviteLink;
}
