package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object contains information about one member of a chat.
 * See <a href="ChatMember">https://core.telegram.org/bots/api#chatmember</a>
 * <p>
 * Field                        Type	    Description
 * user	                        User	    Information about the user
 * status	                    String	    The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
 * until_date	                Integer	    Optional. Restricted and kicked only. Date when restrictions will be lifted for this user, unix time
 * can_be_edited	            Boolean	    Optional. Administrators only. True, if the bot is allowed to edit administrator privileges of that user
 * can_change_info	            Boolean	    Optional. Administrators only. True, if the administrator can change the chat title, photo and other settings
 * can_post_messages	        Boolean	    Optional. Administrators only. True, if the administrator can post in the channel, channels only
 * can_edit_messages	        Boolean	    Optional. Administrators only. True, if the administrator can edit messages of other users and can pin messages, channels only
 * can_delete_messages	        Boolean	    Optional. Administrators only. True, if the administrator can delete messages of other users
 * can_invite_users	            Boolean	    Optional. Administrators only. True, if the administrator can invite new users to the chat
 * can_restrict_members	        Boolean	    Optional. Administrators only. True, if the administrator can restrict, ban or unban chat members
 * can_pin_messages	            Boolean	    Optional. Administrators only. True, if the administrator can pin messages, supergroups only
 * can_promote_members	        Boolean	    Optional. Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * can_send_messages	        Boolean	    Optional. Restricted only. True, if the user can send text messages, contacts, locations and venues
 * can_send_media_messages	    Boolean	    Optional. Restricted only. True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
 * can_send_other_messages	    Boolean	    Optional. Restricted only. True, if the user can send animations, games, stickers and use inline bots, implies can_send_media_messages
 * can_add_web_page_previews	Boolean	    Optional. Restricted only. True, if user may add web page previews to his messages, implies can_send_media_messages
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
