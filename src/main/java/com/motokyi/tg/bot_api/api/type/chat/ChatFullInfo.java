package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.business.BusinessIntro;
import com.motokyi.tg.bot_api.api.type.business.BusinessLocation;
import com.motokyi.tg.bot_api.api.type.business.BusinessOpeningHours;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionType;
import com.motokyi.tg.bot_api.api.type.user.Birthdate;
import java.util.List;
import lombok.Data;

/**
 * This object contains full information about a chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatfullinfo">ChatFullInfo</a>
 */
@Data
public class ChatFullInfo {

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

    @JsonProperty(ApiProperties.ACCENT_COLOR_ID)
    private Long accentColorId;

    @JsonProperty(ApiProperties.MAX_REACTION_COUNT)
    private Integer maxReactionCount;

    private ChatPhoto photo;

    @JsonProperty("active_usernames")
    private List<String> activeUsernames;

    private Birthdate birthdate;

    @JsonProperty(ApiProperties.BUSINESS_INTRO)
    private BusinessIntro businessIntro;

    @JsonProperty(ApiProperties.BUSINESS_LOCATION)
    private BusinessLocation businessLocation;

    @JsonProperty(ApiProperties.BUSINESS_OPENING_HOURS)
    private BusinessOpeningHours businessOpeningHours;

    @JsonProperty(ApiProperties.PERSONAL_CHAT)
    private Chat personalChat;

    @JsonProperty(ApiProperties.AVAILABLE_REACTIONS)
    private List<ReactionType> availableReactions;

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

    @JsonProperty("can_send_gift")
    private Boolean canSendGift;

    @JsonProperty("can_send_paid_media")
    private Boolean canSendPaidMedia;

    @JsonProperty("slow_mode_delay")
    private Integer slowModeDelay;

    @JsonProperty(ApiProperties.UNRESTRICT_BOOST_COUNT)
    private Integer unrestrictBoostCount;

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

    @JsonProperty(ApiProperties.CUSTOM_EMOJI_STICKER_SET_NAME)
    private String customEmojiStickerSetName;

    @JsonProperty("linked_chat_id")
    private Long linkedChatId;

    private ChatLocation location;
}
