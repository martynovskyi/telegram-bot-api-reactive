package com.motokyi.tg.bot_api.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * This object represents a chat.
 * See <a href="Chat">https://core.telegram.org/bots/api#chat</a>
 * <p>
 * Field                            Type	    Description
 * id	                            Integer	    Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * type	                            String	    Type of chat, can be either “private”, “group”, “supergroup” or “channel”
 * title	                        String	    Optional. Title, for supergroups, channels and group chats
 * username	                        String	    Optional. Username, for private chats, supergroups and channels if available
 * first_name	                    String	    Optional. First name of the other party in a private chat
 * last_name	                    String	    Optional. Last name of the other party in a private chat
 * all_members_are_administrators	Boolean	    Optional. True if a group has ‘All Members Are Admins’ enabled.
 * photo	                        ChatPhoto	Optional. Chat photo. Returned only in getChat.
 * description	                    String	    Optional. Description, for supergroups and channel chats. Returned only in getChat.
 * invite_link	                    String	    Optional. Chat invite link, for supergroups and channel chats. Returned only in getChat.
 * pinned_message	                Message	    Optional. Pinned message, for supergroups and channel chats. Returned only in getChat.
 * sticker_set_name	                String	    Optional. For supergroups, name of group sticker set. Returned only in getChat.
 * can_set_sticker_set	            Boolean	    Optional. True, if the bot can change the group sticker set. Returned only in getChat.
 */
@Data
public class Chat {

    private Long id;

    private String type;

    private String title;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("all_members_are_administrators")
    private Boolean allAdmins;

    private ChatPhoto photo;

    private String description;

    @JsonProperty("invite_link")
    private String inviteLink;

    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    @JsonProperty("sticker_set_name")
    private String stickerSetName;

    @JsonProperty("can_set_sticker_set")
    private Boolean canSetStickerSet;

}
