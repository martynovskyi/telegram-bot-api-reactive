package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object contains information about one member of a chat.
 * See <a href="ChatMember">https://core.telegram.org/bots/api#chatmember</a>
 * <p>
 */
@Data
public class ChatMember {
    private User user;

    private String status;

    @JsonProperty("until_date")
    private Integer untilDate;

    @JsonProperty("can_be_edited")
    private Boolean canBeEdited;

    @JsonProperty("can_change_info")
    private Boolean canChangeInfo;

    @JsonProperty("can_post_messages")
    private Boolean canPostMessages;

    @JsonProperty("can_edit_messages")
    private Boolean canEditMessages;

    @JsonProperty("can_delete_messages")
    private Boolean canDeleteMessages;

    @JsonProperty("can_invite_users")
    private Boolean canInviteUsers;

    @JsonProperty("can_restrict_members")
    private Boolean canRestrictMembers;

    @JsonProperty("can_pin_messages")
    private Boolean canPinMessages;

    @JsonProperty("can_promote_members")
    private Boolean canPromoteMembers;

    @JsonProperty("can_send_messages")
    private Boolean canSendMessages;

    @JsonProperty("can_send_media_messages")
    private Boolean canSendMediaMessages;

    @JsonProperty("can_send_other_messages")
    private Boolean canSendOtherMessages;

    @JsonProperty("can_add_web_page_previews")
    private Boolean canAddWebPagePreviews;

}
