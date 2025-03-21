package com.motokyi.tg.bot_api.api.type.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.UpdateTypes;
import com.motokyi.tg.bot_api.api.type.business.BusinessConnection;
import com.motokyi.tg.bot_api.api.type.business.BusinessMessagesDeleted;
import com.motokyi.tg.bot_api.api.type.chat.ChatJoinRequest;
import com.motokyi.tg.bot_api.api.type.chat_boost.ChatBoostRemoved;
import com.motokyi.tg.bot_api.api.type.chat_boost.ChatBoostUpdated;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberUpdated;
import com.motokyi.tg.bot_api.api.type.inline.ChosenInlineResult;
import com.motokyi.tg.bot_api.api.type.inline.InlineQuery;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.media.PaidMediaPurchased;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.message.MessageReactionCountUpdated;
import com.motokyi.tg.bot_api.api.type.message.MessageReactionUpdated;
import com.motokyi.tg.bot_api.api.type.payment.PreCheckoutQuery;
import com.motokyi.tg.bot_api.api.type.payment.ShippingQuery;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.poll.PollAnswer;
import lombok.Data;

/**
 * This object represents an incoming update. At most one of the optional parameters can be present
 * in any given update.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#update">Update</a>
 */
@Data
public class Update {
    @JsonProperty(ApiProperties.UPDATE_ID)
    private Long updateId;

    @JsonProperty(UpdateTypes.MESSAGE)
    private Message message;

    @JsonProperty(UpdateTypes.EDITED_MESSAGE)
    private Message editedMessage;

    @JsonProperty(UpdateTypes.CHANNEL_POST)
    private Message channelPost;

    @JsonProperty(UpdateTypes.EDITED_CHANNEL_POST)
    private Message editedChannelPost;

    @JsonProperty(UpdateTypes.BUSINESS_CONNECTION)
    private BusinessConnection businessConnection;

    @JsonProperty(UpdateTypes.BUSINESS_MESSAGE)
    private Message businessMessage;

    @JsonProperty(UpdateTypes.EDITED_BUSINESS_MESSAGE)
    private Message editedBusinessMessage;

    @JsonProperty(UpdateTypes.DELETED_BUSINESS_MESSAGES)
    private BusinessMessagesDeleted deletedBusinessMessages;

    @JsonProperty(UpdateTypes.MESSAGE_REACTION)
    private MessageReactionUpdated messageReaction;

    @JsonProperty(UpdateTypes.MESSAGE_REACTION_COUNT)
    private MessageReactionCountUpdated messageReactionCount;

    @JsonProperty(UpdateTypes.INLINE_QUERY)
    private InlineQuery inlineQuery;

    @JsonProperty(UpdateTypes.CHOSEN_INLINE_RESULT)
    private ChosenInlineResult chosenInlineResult;

    @JsonProperty(UpdateTypes.CALLBACK_QUERY)
    private CallbackQuery callbackQuery;

    @JsonProperty(UpdateTypes.SHIPPING_QUERY)
    private ShippingQuery shippingQuery;

    @JsonProperty(UpdateTypes.PRE_CHECKOUT_QUERY)
    private PreCheckoutQuery preCheckoutQuery;

    @JsonProperty(UpdateTypes.PURCHASED_PAID_MEDIA)
    private PaidMediaPurchased purchasedPaidMedia;

    @JsonProperty(UpdateTypes.POLL)
    private Poll poll;

    @JsonProperty(UpdateTypes.POLL_ANSWER)
    private PollAnswer pollAnswer;

    @JsonProperty(UpdateTypes.MY_CHAT_MEMBER)
    private ChatMemberUpdated myChatMember;

    @JsonProperty(UpdateTypes.CHAT_MEMBER)
    private ChatMemberUpdated chatMember;

    @JsonProperty(UpdateTypes.CHAT_JOIN_REQUEST)
    private ChatJoinRequest chatJoinRequest;

    @JsonProperty(UpdateTypes.CHAT_BOOST)
    private ChatBoostUpdated chatBoost;

    @JsonProperty(UpdateTypes.REMOVED_CHAT_BOOST)
    private ChatBoostRemoved removedChatBoost;
}
