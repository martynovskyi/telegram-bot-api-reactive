package com.motokyi.tg.bot_api.tools;

import static com.motokyi.tg.bot_api.api.constant.UpdateTypes.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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
import com.motokyi.tg.bot_api.api.type.update.Update;
import java.util.function.Consumer;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
public class UpdateHandler {
    private final Consumer<Message> messageConsumer;
    private final Consumer<Message> editedMessageConsumer;
    private final Consumer<Message> channelPostConsumer;
    private final Consumer<Message> editedChannelPostConsumer;
    private final Consumer<BusinessConnection> businessConnectionConsumer;
    private final Consumer<Message> businessMessageConsumer;
    private final Consumer<Message> editedBusinessMessageConsumer;
    private final Consumer<BusinessMessagesDeleted> deletedBusinessMessagesConsumer;
    private final Consumer<MessageReactionUpdated> messageReactionConsumer;
    private final Consumer<MessageReactionCountUpdated> messageReactionCountUpdatedConsumer;
    private final Consumer<InlineQuery> inlineQueryConsumer;
    private final Consumer<ChosenInlineResult> chosenInlineResultConsumer;
    private final Consumer<CallbackQuery> callbackQueryConsumer;
    private final Consumer<ShippingQuery> shippingQueryConsumer;
    private final Consumer<PreCheckoutQuery> preCheckoutQueryConsumer;
    private final Consumer<PaidMediaPurchased> purchasedPaidMediaConsumer;
    private final Consumer<Poll> pollConsumer;
    private final Consumer<PollAnswer> pollAnswerConsumer;
    private final Consumer<ChatMemberUpdated> myChatMemberConsumer;
    private final Consumer<ChatMemberUpdated> chatMemberConsumer;
    private final Consumer<ChatJoinRequest> chatJoinRequestConsumer;
    private final Consumer<ChatBoostUpdated> chatBoostUpdatedConsumer;
    private final Consumer<ChatBoostRemoved> chatBoostRemovedConsumer;

    public void apply(Update update) {
        if (isNull(update)) {
            log.warn("Empty update received");
            return;
        }
        apply(MESSAGE, update.getMessage(), messageConsumer);
        apply(EDITED_MESSAGE, update.getEditedMessage(), editedMessageConsumer);
        apply(CHANNEL_POST, update.getChannelPost(), channelPostConsumer);
        apply(EDITED_CHANNEL_POST, update.getEditedChannelPost(), editedChannelPostConsumer);
        apply(BUSINESS_CONNECTION, update.getBusinessConnection(), businessConnectionConsumer);
        apply(BUSINESS_MESSAGE, update.getBusinessMessage(), businessMessageConsumer);
        apply(
                EDITED_BUSINESS_MESSAGE, update.getEditedBusinessMessage(), editedBusinessMessageConsumer);
        apply(
                DELETED_BUSINESS_MESSAGES,
                update.getDeletedBusinessMessages(),
                deletedBusinessMessagesConsumer);
        apply(MESSAGE_REACTION, update.getMessageReaction(), messageReactionConsumer);
        apply(
                MESSAGE_REACTION_COUNT,
                update.getMessageReactionCount(),
                messageReactionCountUpdatedConsumer);
        apply(INLINE_QUERY, update.getInlineQuery(), inlineQueryConsumer);
        apply(CHOSEN_INLINE_RESULT, update.getChosenInlineResult(), chosenInlineResultConsumer);
        apply(CALLBACK_QUERY, update.getCallbackQuery(), callbackQueryConsumer);
        apply(SHIPPING_QUERY, update.getShippingQuery(), shippingQueryConsumer);
        apply(PRE_CHECKOUT_QUERY, update.getPreCheckoutQuery(), preCheckoutQueryConsumer);
        apply(PURCHASED_PAID_MEDIA, update.getPurchasedPaidMedia(), purchasedPaidMediaConsumer);
        apply(POLL, update.getPoll(), pollConsumer);
        apply(POLL_ANSWER, update.getPollAnswer(), pollAnswerConsumer);
        apply(MY_CHAT_MEMBER, update.getMyChatMember(), myChatMemberConsumer);
        apply(CHAT_MEMBER, update.getChatMember(), chatMemberConsumer);
        apply(CHAT_JOIN_REQUEST, update.getChatJoinRequest(), chatJoinRequestConsumer);
        apply(CHAT_BOOST, update.getChatBoost(), chatBoostUpdatedConsumer);
        apply(REMOVED_CHAT_BOOST, update.getRemovedChatBoost(), chatBoostRemovedConsumer);
    }

    private <T> void apply(String eventType, T eventData, Consumer<T> consumer) {
        if (nonNull(eventData)) {
            if (nonNull(consumer)) {
                consumer.accept(eventData);
            } else {
                log.warn("Consumer for {} not defined", eventType);
            }
        }
    }
}
