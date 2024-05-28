package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#chatpermissions">ChatPermissions</a>
 */
@Data
public class ChatPermissions {

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

    @JsonProperty(ApiProperties.CAN_CHANGE_INFO)
    private Boolean canChangeInfo;

    @JsonProperty(ApiProperties.CAN_INVITE_USERS)
    private Boolean canInviteUsers;

    @JsonProperty(ApiProperties.CAN_PIN_MESSAGES)
    private Boolean canPinMessages;

    @JsonProperty(ApiProperties.CAN_MANAGE_TOPICS)
    private Boolean canManageTopics;
}
