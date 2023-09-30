package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Represents the rights of an administrator in a chat.
 * See <a href="ChatAdministratorRights">https://core.telegram.org/bots/api#chatadministratorrights</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ChatAdministratorRights {

    @JsonProperty(ApiProperties.IS_ANONYMOUS)
    private Boolean isAnonymous;

    @JsonProperty(ApiProperties.CAN_MANAGE_CHAT)
    private Boolean canManageChat;

    @JsonProperty(ApiProperties.CAN_DELETE_MESSAGES)
    private Boolean canDeleteMessages;

    @JsonProperty(ApiProperties.CAN_MANAGE_VIDEO_CHATS)
    private Boolean canManageVideoChats;

    @JsonProperty(ApiProperties.CAN_RESTRICT_MEMBERS)
    private Boolean canRestrictMembers;

    @JsonProperty(ApiProperties.CAN_PROMOTE_MEMBERS)
    private Boolean canPromoteMembers;

    @JsonProperty(ApiProperties.CAN_CHANGE_INFO)
    private Boolean canChangeInfo;

    @JsonProperty(ApiProperties.CAN_INVITE_USERS)
    private Boolean canInviteUsers;

    @JsonProperty(ApiProperties.CAN_POST_MESSAGES)
    private Boolean canPostMessages;

    @JsonProperty(ApiProperties.CAN_EDIT_MESSAGES)
    private Boolean canEditMessages;

    @JsonProperty(ApiProperties.CAN_PIN_MESSAGES)
    private Boolean canPinMessages;

    @JsonProperty(ApiProperties.CAN_POST_STORIES)
    private Boolean canPostStories;

    @JsonProperty(ApiProperties.CAN_EDIT_STORIES)
    private Boolean canEditStories;

    @JsonProperty(ApiProperties.CAN_DELETE_STORIES)
    private Boolean canDeleteStories;

    @JsonProperty(ApiProperties.CAN_MANAGE_TOPICS)
    private Boolean canManageTopics;
}
