package com.motokyi.tg.bot_api.tools;

import com.motokyi.tg.bot_api.api.type.business.BusinessConnection;
import com.motokyi.tg.bot_api.api.type.business.BusinessMessagesDeleted;
import com.motokyi.tg.bot_api.api.type.chat.ChatJoinRequest;
import com.motokyi.tg.bot_api.api.type.chat_boost.ChatBoostRemoved;
import com.motokyi.tg.bot_api.api.type.chat_boost.ChatBoostUpdated;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberUpdated;
import com.motokyi.tg.bot_api.api.type.inline.ChosenInlineResult;
import com.motokyi.tg.bot_api.api.type.inline.InlineQuery;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.message.MessageReactionCountUpdated;
import com.motokyi.tg.bot_api.api.type.message.MessageReactionUpdated;
import com.motokyi.tg.bot_api.api.type.payment.PreCheckoutQuery;
import com.motokyi.tg.bot_api.api.type.payment.ShippingQuery;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.poll.PollAnswer;
import com.motokyi.tg.bot_api.api.type.update.Update;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

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
    private final Consumer<Poll> pollConsumer;
    private final Consumer<PollAnswer> pollAnswerConsumer;
    private final Consumer<ChatMemberUpdated> myChatMemberConsumer;
    private final Consumer<ChatMemberUpdated> chatMemberConsumer;
    private final Consumer<ChatJoinRequest> chatJoinRequestConsumer;
    private final Consumer<ChatBoostUpdated> chatBoostUpdatedConsumer;
    private final Consumer<ChatBoostRemoved> chatBoostRemovedConsumer;

    public void apply(Update update) {
        if (nonNull(update)) {
            ofNullable(update.getMessage()).ifPresent(handleSafe(this.messageConsumer));
            ofNullable(update.getEditedMessage()).ifPresent(handleSafe(this.editedMessageConsumer));
            ofNullable(update.getChannelPost()).ifPresent(handleSafe(this.channelPostConsumer));
            ofNullable(update.getEditedMessage()).ifPresent(handleSafe(this.editedChannelPostConsumer));
            ofNullable(update.getBusinessConnection()).ifPresent(handleSafe(this.businessConnectionConsumer));
            ofNullable(update.getBusinessMessage()).ifPresent(handleSafe(this.businessMessageConsumer));
            ofNullable(update.getEditedBusinessMessage()).ifPresent(handleSafe(this.editedBusinessMessageConsumer));
            ofNullable(update.getDeletedBusinessMessages()).ifPresent(handleSafe(this.deletedBusinessMessagesConsumer));
            ofNullable(update.getMessageReaction()).ifPresent(handleSafe(this.messageReactionConsumer));
            ofNullable(update.getMessageReactionCountUpdated())
                    .ifPresent(handleSafe(this.messageReactionCountUpdatedConsumer));
            ofNullable(update.getInlineQuery()).ifPresent(handleSafe(this.inlineQueryConsumer));
            ofNullable(update.getChosenInlineResult()).ifPresent(handleSafe(this.chosenInlineResultConsumer));
            ofNullable(update.getCallbackQuery()).ifPresent(handleSafe(this.callbackQueryConsumer));
            ofNullable(update.getShippingQuery()).ifPresent(handleSafe(this.shippingQueryConsumer));
            ofNullable(update.getPreCheckoutQuery()).ifPresent(handleSafe(this.preCheckoutQueryConsumer));
            ofNullable(update.getPoll()).ifPresent(handleSafe(this.pollConsumer));
            ofNullable(update.getPollAnswer()).ifPresent(handleSafe(this.pollAnswerConsumer));
            ofNullable(update.getMyChatMember()).ifPresent(handleSafe(this.myChatMemberConsumer));
            ofNullable(update.getChatMember()).ifPresent(handleSafe(this.chatMemberConsumer));
            ofNullable(update.getChatJoinRequest()).ifPresent(handleSafe(this.chatJoinRequestConsumer));
            ofNullable(update.getChatBoost()).ifPresent(handleSafe(this.chatBoostUpdatedConsumer));
            ofNullable(update.getChatBoostRemoved()).ifPresent(handleSafe(this.chatBoostRemovedConsumer));
        }
    }

    private <T> Consumer<T> handleSafe(Consumer<T> consumer) {
        if (Objects.nonNull(consumer)) {
            return consumer;
        }
        return t -> log.warn("Consumer for {} not defined", t.getClass().getSimpleName());
    }
}
