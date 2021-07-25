package com.motokyi.tg.botapi.components.tools;

import com.motokyi.tg.botapi.api.types.ChosenInlineResult;
import com.motokyi.tg.botapi.api.types.InlineQuery;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.PreCheckoutQuery;
import com.motokyi.tg.botapi.api.types.ShippingQuery;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.api.types.markup.CallbackQuery;
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
        }
    }

    private <T> Consumer<T> handleSafe(Consumer<T> consumer) {
        if (Objects.nonNull(consumer)) {
            return consumer;
        }
        return t -> log.warn("Consumer for {} not defined", t.getClass().getSimpleName());
    }
}
