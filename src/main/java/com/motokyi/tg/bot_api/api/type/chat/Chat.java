package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.Message;
import lombok.Data;

import java.util.List;


/**
 * This object represents a chat.
 * See <a href="Chat">https://core.telegram.org/bots/api#chat</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class Chat {

    private Long id;

    private String type;

    private String title;

    @JsonProperty("username")
    private String userName;

    @JsonProperty(ApiProperties.FIRST_NAME)
    private String firstName;

    @JsonProperty(ApiProperties.LAST_NAME)
    private String lastName;

    @JsonProperty("is_forum")
    private Boolean isForum;

    private ChatPhoto photo;

    @JsonProperty("active_usernames")
    private List<String> activeUsernames;

    @JsonProperty("emoji_status_custom_emoji_id")
    private String emojiStatusCustomEmojiId;

    @JsonProperty("emoji_status_expiration_date")
    private Long emojiStatusExpirationDate;

    private String bio;

    @JsonProperty("has_private_forwards")
    private Boolean hasPrivateForwards;

    @JsonProperty("has_restricted_voice_and_video_messages")
    private Boolean hasRestrictedVoiceAndVideoMessages;

    @JsonProperty("join_to_send_messages")
    private Boolean joinToSendMessages;

    @JsonProperty("join_by_request")
    private Boolean joinByRequest;

    private String description;

    @JsonProperty(ApiProperties.INVITE_LINK)
    private String inviteLink;

    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    private ChatPermissions permissions;

    @JsonProperty("slow_mode_delay")
    private Integer slowModeDelay;

    @JsonProperty("message_auto_delete_time")
    private Long messageAutoDeleteTime;

    @JsonProperty("has_aggressive_anti_spam_enabled")
    private Boolean hasAggressiveAntiSpamEnabled;

    @JsonProperty("has_hidden_members")
    private Boolean hasHiddenMembers;

    @JsonProperty("has_protected_content")
    private Boolean hasProtectedContent;

    @JsonProperty("sticker_set_name")
    private String stickerSetName;

    @JsonProperty("can_set_sticker_set")
    private Boolean canSetStickerSet;

    @JsonProperty("linked_chat_id")
    private Long linkedChatId;

    private ChatLocation location;

}
