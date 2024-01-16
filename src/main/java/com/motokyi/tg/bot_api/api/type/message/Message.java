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
import com.motokyi.tg.bot_api.api.type.message.origin.MessageOrigin;
import com.motokyi.tg.bot_api.api.type.message.reply.ExternalReplyInfo;
import com.motokyi.tg.bot_api.api.type.message.reply.TextQuote;
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
 * @version Bot API 7.0
 */
@Data
public class Message {

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    private Long messageThreadId;

    private User from;

    @JsonProperty(ApiProperties.SENDER_CHAT)
    private Chat senderChat;

    private Long date;

    private Chat chat;

    @JsonProperty(ApiProperties.FORWARD_ORIGIN)
    private MessageOrigin forwardOrigin;

    @JsonProperty("is_topic_message")
    private Boolean isTopicMessage;

    @JsonProperty("is_automatic_forward")
    private Boolean isAutomaticForward;

    @JsonProperty("reply_to_message")
    private Message replyToMessage;

    @JsonProperty(ApiProperties.EXTERNAL_REPLY)
    private ExternalReplyInfo externalReply;

    private TextQuote quote;

    @JsonProperty("via_bot")
    private User viaBot;

    @JsonProperty(ApiProperties.EDIT_DATE)
    private Long editDate;

    @JsonProperty(ApiProperties.HAS_PROTECTED_CONTENT)
    private Message hasProtectedContent;

    @JsonProperty("media_group_id")
    private String mediaGroupId;

    @JsonProperty(ApiProperties.AUTHOR_SIGNATURE)
    private String authorSignature;

    private String text;

    private List<MessageEntity> entities;

    //todo: private LinkPreviewOptions link_preview_options;

    private Animation animation;

    private Audio audio;

    private Document document;

    @JsonProperty(ApiProperties.PHOTO)
    private List<PhotoSize> photo;

    private Sticker sticker;

    private Story story;

    private Video video;

    @JsonProperty(ApiProperties.VIDEO_NOTE)
    private VideoNote videoNote;

    private Voice voice;

    private String caption;

    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities;

    @JsonProperty(ApiProperties.HAS_MEDIA_SPOILER)
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

    @JsonProperty(ApiProperties.PINNED_MESSAGE)
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

    //todo: private GiveawayCreated giveaway_created;
    //todo: private Giveaway giveaway;
    //todo: private GiveawayWinners giveaway_winners;
    //todo: private GiveawayCompleted giveaway_completed;

    @JsonProperty("video_chat_scheduled")
    private VideoChatScheduled videoChatScheduled;

    @JsonProperty("video_chat_started")
    private VideoChatStarted videoChatStarted;

    @JsonProperty("video_chat_ended")
    private VideoChatEnded videoChatEnded;

    @JsonProperty("video_chat_participants_invited")
    private VideoChatParticipantsInvited videoChatParticipantsInvited;

    @JsonProperty(ApiProperties.WEB_APP_DATA)
    private WebAppData webAppData;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    private InlineKeyboardMarkup replyMarkup;
}
