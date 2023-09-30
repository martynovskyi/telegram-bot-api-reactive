package com.motokyi.tg.bot_api.api.type.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.UpdateType;
import com.motokyi.tg.bot_api.api.type.ChosenInlineResult;
import com.motokyi.tg.bot_api.api.type.chat.ChatJoinRequest;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberUpdated;
import com.motokyi.tg.bot_api.api.type.inline.InlineQuery;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.payment.PreCheckoutQuery;
import com.motokyi.tg.bot_api.api.type.payment.ShippingQuery;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.poll.PollAnswer;
import lombok.Data;

/**
 * This object represents an incoming update.
 * At most one of the optional parameters can be present in any given update.
 * See <a href="Update">https://core.telegram.org/bots/api#update</a>
 * <p>
 *
 * @version Bot API 6.9
 */

@Data
public class Update {
    @JsonProperty("update_id")
    private Long updateId;

    @JsonProperty(UpdateType.MESSAGE)
    private Message message;

    @JsonProperty(UpdateType.EDITED_MESSAGE)
    private Message editedMessage;

    @JsonProperty(UpdateType.CHANNEL_POST)
    private Message channelPost;

    @JsonProperty(UpdateType.EDITED_CHANNEL_POST)
    private Message editedChannelPost;

    @JsonProperty(UpdateType.INLINE_QUERY)
    private InlineQuery inlineQuery;

    @JsonProperty(UpdateType.CHOSEN_INLINE_RESULT)
    private ChosenInlineResult chosenInlineResult;

    @JsonProperty(UpdateType.CALLBACK_QUERY)
    private CallbackQuery callbackQuery;

    @JsonProperty(UpdateType.SHIPPING_QUERY)
    private ShippingQuery shippingQuery;

    @JsonProperty(UpdateType.PRE_CHECKOUT_QUERY)
    private PreCheckoutQuery preCheckoutQuery;

    @JsonProperty(UpdateType.POLL)
    private Poll poll;

    @JsonProperty(UpdateType.POLL_ANSWER)
    private PollAnswer pollAnswer;

    @JsonProperty(UpdateType.MY_CHAT_MEMBER)
    private ChatMemberUpdated myChatMember;

    @JsonProperty(UpdateType.CHAT_MEMBER)
    private ChatMemberUpdated chatMember;

    @JsonProperty(UpdateType.CHAT_JOIN_REQUEST)
    private ChatJoinRequest chatJoinRequest;
}
