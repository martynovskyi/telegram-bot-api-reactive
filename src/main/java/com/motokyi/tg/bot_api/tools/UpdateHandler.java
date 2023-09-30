package com.motokyi.tg.bot_api.tools;

import com.motokyi.tg.bot_api.api.type.ChosenInlineResult;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberUpdated;
import com.motokyi.tg.bot_api.api.type.inline.InlineQuery;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.payment.PreCheckoutQuery;
import com.motokyi.tg.bot_api.api.type.payment.ShippingQuery;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.poll.PollAnswer;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

@Builder
@Slf4j
public class UpdateHandler {
    private final Consumer<Message>
            messageConsumer,
            editedMessageConsumer,
            channelPostConsumer,
            editedChannelPostConsumer;
    private final Consumer<InlineQuery> inlineQueryConsumer;
    private final Consumer<ChosenInlineResult> chosenInlineResultConsumer;
    private final Consumer<CallbackQuery> callbackQueryConsumer;
    private final Consumer<ShippingQuery> shippingQueryConsumer;
    private final Consumer<PreCheckoutQuery> preCheckoutQueryConsumer;
    private final Consumer<Poll> pollConsumer;
    private final Consumer<PollAnswer> pollAnswerConsumer;
    private final Consumer<ChatMemberUpdated> myChatMemberConsumer;
    private final Consumer<ChatMemberUpdated> chatMemberConsumer;

    public void apply(Update update) {
        if (nonNull(update)) {
            ofNullable(update.getMessage()).ifPresent(handleSafe(this.messageConsumer));
            ofNullable(update.getEditedMessage()).ifPresent(handleSafe(this.editedMessageConsumer));
            ofNullable(update.getChannelPost()).ifPresent(handleSafe(this.channelPostConsumer));
            ofNullable(update.getEditedMessage()).ifPresent(handleSafe(this.editedChannelPostConsumer));
            ofNullable(update.getInlineQuery()).ifPresent(handleSafe(this.inlineQueryConsumer));
            ofNullable(update.getChosenInlineResult()).ifPresent(handleSafe(this.chosenInlineResultConsumer));
            ofNullable(update.getCallbackQuery()).ifPresent(handleSafe(this.callbackQueryConsumer));
            ofNullable(update.getShippingQuery()).ifPresent(handleSafe(this.shippingQueryConsumer));
            ofNullable(update.getPreCheckoutQuery()).ifPresent(handleSafe(this.preCheckoutQueryConsumer));
            ofNullable(update.getPoll()).ifPresent(handleSafe(this.pollConsumer));
            ofNullable(update.getPollAnswer()).ifPresent(handleSafe(this.pollAnswerConsumer));
            ofNullable(update.getMyChatMember()).ifPresent(handleSafe(this.myChatMemberConsumer));
            ofNullable(update.getChatMember()).ifPresent(handleSafe(this.chatMemberConsumer));
        }
    }

    private <T> Consumer<T> handleSafe(Consumer<T> consumer) {
        if (Objects.nonNull(consumer)) {
            return consumer;
        }
        return t -> log.warn("Consumer for {} not defined", t.getClass().getSimpleName());
    }
}
