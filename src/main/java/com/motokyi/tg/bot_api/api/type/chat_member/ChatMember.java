package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object contains information about one member of a chat.
 * <ul>Currently, the following 6 types of chat members are supported:
 * <li> ChatMemberOwner
 * <li> ChatMemberAdministrator
 * <li> ChatMemberMember
 * <li> ChatMemberRestricted
 * <li> ChatMemberLeft
 * <li> ChatMemberBanned
 * </ul>
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#chatmember">ChatMember</a>
 */
@Data
public class ChatMember {

    // todo: need to split this class according to documentation
    private User user;

    private String status;

    @JsonProperty(ApiProperties.IS_ANONYMOUS)
    private Boolean isAnonymous;

    @JsonProperty(ApiProperties.CUSTOM_TITLE)
    private String customTitle;

    @JsonProperty(ApiProperties.CAN_BE_EDITED)
    private Boolean canBeEdited;

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

    @JsonProperty(ApiProperties.IS_MEMBER)
    private Boolean isMember;

    @JsonProperty(ApiProperties.CAN_SEND_MESSAGES)
    private Boolean canSendMessages;

    @JsonProperty(ApiProperties.CAN_SEND_AUDIOS)
    private Boolean canSendAudios;

    @JsonProperty(ApiProperties.CAN_SEND_DOCUMENTS)
    private Boolean canSendDocuments;

    @JsonProperty(ApiProperties.CAN_SEND_PHOTOS)
    private Boolean canSendPhotos;

    @JsonProperty(ApiProperties.CAN_SEND_VIDEOS)
    private Boolean canSendVideos;

    @JsonProperty(ApiProperties.CAN_SEND_VIDEO_NOTES)
    private Boolean canSendVideoNotes;

    @JsonProperty(ApiProperties.CAN_SEND_VOICE_NOTES)
    private Boolean canSendVoiceNotes;

    @JsonProperty(ApiProperties.CAN_SEND_POLLS)
    private Boolean canSendPolls;

    @JsonProperty(ApiProperties.CAN_SEND_OTHER_MESSAGES)
    private Boolean canSendOtherMessages;

    @JsonProperty(ApiProperties.CAN_ADD_WEB_PAGE_PREVIEWS)
    private Boolean canAddWebPagePreviews;

    @JsonProperty(ApiProperties.UNTIL_DATE)
    private Long untilDate;

}
