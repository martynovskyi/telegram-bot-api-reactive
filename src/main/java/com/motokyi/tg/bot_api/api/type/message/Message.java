package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.*;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.chat.ChatShared;
import com.motokyi.tg.bot_api.api.type.chat.ProximityAlertTriggered;
import com.motokyi.tg.bot_api.api.type.forum.*;
import com.motokyi.tg.bot_api.api.type.game.Game;
import com.motokyi.tg.bot_api.api.type.inline.InlineKeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.media.*;
import com.motokyi.tg.bot_api.api.type.passport.PassportData;
import com.motokyi.tg.bot_api.api.type.payment.Invoice;
import com.motokyi.tg.bot_api.api.type.payment.SuccessfulPayment;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.sticker.Sticker;
import com.motokyi.tg.bot_api.api.type.user.User;
import com.motokyi.tg.bot_api.api.type.user.UserShared;
import com.motokyi.tg.bot_api.api.type.video_chat.VideoChatEnded;
import com.motokyi.tg.bot_api.api.type.video_chat.VideoChatParticipantsInvited;
import com.motokyi.tg.bot_api.api.type.video_chat.VideoChatScheduled;
import com.motokyi.tg.bot_api.api.type.video_chat.VideoChatStarted;
import com.motokyi.tg.bot_api.api.type.web_app.WebAppData;
import com.motokyi.tg.bot_api.api.type.web_app.WriteAccessAllowed;
import lombok.Data;

import java.util.List;

/**
 * This object represents a message.
 * See <a href="Message">https://core.telegram.org/bots/api#message</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class Message {

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    private Long message_thread_id;

    private User from;

    @JsonProperty("sender_chat")
    private Chat senderChat;

    private Long date;

    private Chat chat;

    @JsonProperty("forward_from")
    private User forwardFrom;

    @JsonProperty("forward_from_chat")
    private Chat forwardFromChat;

    @JsonProperty("forward_from_message_id")
    private Long forwardFromMessageId;

    @JsonProperty("forward_signature")
    private String forwardSignature;

    @JsonProperty("forward_sender_name")
    private String forwardSenderName;

    @JsonProperty("forward_date")
    private Long forwardDate;

    @JsonProperty("is_topic_message")
    private Boolean isTopicMessage;

    @JsonProperty("is_automatic_forward")
    private Boolean isAutomaticForward;

    @JsonProperty("reply_to_message")
    private Message replyToMessage;

    @JsonProperty("via_bot")
    private User viaBot;

    @JsonProperty("edit_date")
    private Long editDate;

    @JsonProperty("has_protected_content")
    private Message hasProtectedContent;

    @JsonProperty("media_group_id")
    private String mediaGroupId;

    @JsonProperty("author_signature")
    private String authorSignature;

    private String text;

    private List<MessageEntity> entities;

    private Animation animation;

    private Audio audio;

    private Document document;

    @JsonProperty("photo")
    private List<PhotoSize> photo;

    private Sticker sticker;

    private Story story;

    private Video video;

    @JsonProperty("video_note")
    private VideoNote videoNote;

    private Voice voice;

    private String caption;

    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities;

    @JsonProperty("has_media_spoiler")
    private Boolean hasMediaSpoiler;

    private Contact contact;

    private Dice dice;

    private Game game;

    private Poll poll;

    private Venue venue;

    private Location location;

    @JsonProperty("new_chat_members")
    private List<User> newChatMembers;

    @JsonProperty("left_chat_member")
    private User leftChatMember;

    @JsonProperty("new_chat_title")
    private String newChatTitle;

    @JsonProperty("new_chat_photo")
    private List<PhotoSize> newChatPhoto;

    @JsonProperty("delete_chat_photo")
    private Boolean deleteChatPhoto;

    @JsonProperty("group_chat_created")
    private Boolean groupChatCreated;

    @JsonProperty("supergroup_chat_created")
    private Boolean supergroupChatCreated;

    @JsonProperty("channel_chat_created")
    private Boolean channelChatCreated;

    @JsonProperty("message_auto_delete_timer_changed")
    private MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;

    @JsonProperty("migrate_to_chat_id")
    private Long migrateToChatId;

    @JsonProperty("migrate_from_chat_id")
    private Long migrateFromChatId;

    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    private Invoice invoice;

    @JsonProperty("successful_payment")
    private SuccessfulPayment successfulPayment;

    @JsonProperty("user_shared")
    private UserShared userShared;

    @JsonProperty("chat_shared")
    private ChatShared chatShared;

    @JsonProperty("connected_website")
    private String connectedWebsite;

    @JsonProperty("write_access_allowed")
    private WriteAccessAllowed writeAccessAllowed;

    @JsonProperty("passport_data")
    private PassportData passportData;

    @JsonProperty("proximity_alert_triggered")
    private ProximityAlertTriggered proximityAlertTriggered;

    @JsonProperty("forum_topic_created")
    private ForumTopicCreated forumTopicCreated;

    @JsonProperty("forum_topic_edited")
    private ForumTopicEdited forumTopicEdited;

    @JsonProperty("forum_topic_closed")
    private ForumTopicClosed forumTopicClosed;

    @JsonProperty("forum_topic_reopened")
    private ForumTopicReopened forumTopicReopened;

    @JsonProperty("general_forum_topic_hidden")
    private GeneralForumTopicHidden generalForumTopicHidden;

    @JsonProperty("general_forum_topic_unhidden")
    private GeneralForumTopicUnhidden generalForumTopicUnhidden;

    @JsonProperty("video_chat_scheduled")
    private VideoChatScheduled videoChatScheduled;

    @JsonProperty("video_chat_started")
    private VideoChatStarted videoChatStarted;

    @JsonProperty("video_chat_ended")
    private VideoChatEnded videoChatEnded;

    @JsonProperty("video_chat_participants_invited")
    private VideoChatParticipantsInvited videoChatParticipantsInvited;

    @JsonProperty("web_app_data")
    private WebAppData webAppData;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    private InlineKeyboardMarkup replyMarkup;
}
