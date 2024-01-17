package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionType;
import lombok.Data;

import java.util.List;


/**
 * This object represents a chat.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#chat">Chat</a>
 */
@Data
public class Chat {

    private Long id;

    private String type;

    private String title;

    @JsonProperty(ApiProperties.USERNAME)
    private String userName;

    @JsonProperty(ApiProperties.FIRST_NAME)
    private String firstName;

    @JsonProperty(ApiProperties.LAST_NAME)
    private String lastName;

    @JsonProperty(ApiProperties.IS_FORUM)
    private Boolean isForum;

    private ChatPhoto photo;

    @JsonProperty("active_usernames")
    private List<String> activeUsernames;

    @JsonProperty(ApiProperties.AVAILABLE_REACTIONS)
    private List<ReactionType> availableReactions;

    @JsonProperty(ApiProperties.ACCENT_COLOR_ID)
    private Long accentColorId;

    @JsonProperty(ApiProperties.BACKGROUND_CUSTOM_EMOJI_ID)
    private String backgroundCustomEmojiId;

    @JsonProperty(ApiProperties.PROFILE_ACCENT_COLOR_ID)
    private Long profileAccentColorId;

    @JsonProperty(ApiProperties.PROFILE_BACKGROUND_CUSTOM_EMOJI_ID)
    private String profileBackgroundCustomEmojiId;

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

    @JsonProperty(ApiProperties.PINNED_MESSAGE)
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

    @JsonProperty(ApiProperties.HAS_PROTECTED_CONTENT)
    private Boolean hasProtectedContent;

    @JsonProperty(ApiProperties.HAS_VISIBLE_HISTORY)
    private Boolean hasVisibleHistory;

    @JsonProperty("sticker_set_name")
    private String stickerSetName;

    @JsonProperty("can_set_sticker_set")
    private Boolean canSetStickerSet;

    @JsonProperty("linked_chat_id")
    private Long linkedChatId;

    private ChatLocation location;

}
