package com.motokyi.tg.botapi.components.tools;

import com.motokyi.tg.botapi.api.types.*;
import com.motokyi.tg.botapi.api.types.markup.CallbackQuery;
import lombok.Builder;

import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

@Builder
public class UpdateProcessor {
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
            ofNullable(update.getMessage()).ifPresent(this.messageConsumer);
            ofNullable(update.getEditedMessage()).ifPresent(this.editedMessageConsumer);
            ofNullable(update.getChannelPost()).ifPresent(this.channelPostConsumer);
            ofNullable(update.getEditedMessage()).ifPresent(this.editedChannelPostConsumer);
            ofNullable(update.getInlineQuery()).ifPresent(this.inlineQueryConsumer);
            ofNullable(update.getChosenInlineResult()).ifPresent(this.chosenInlineResultConsumer);
            ofNullable(update.getCallbackQuery()).ifPresent(this.callbackQueryConsumer);
            ofNullable(update.getShippingQuery()).ifPresent(this.shippingQueryConsumer);
            ofNullable(update.getPreCheckoutQuery()).ifPresent(this.preCheckoutQueryConsumer);
        }
    }
}
