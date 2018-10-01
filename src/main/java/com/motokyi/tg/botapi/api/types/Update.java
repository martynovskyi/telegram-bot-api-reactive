package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.markup.CallbackQuery;
import lombok.Data;

/**
 * This object represents an incoming update.
 * At most one of the optional parameters can be present in any given update.
 * See <a href="Update">https://core.telegram.org/bots/api#update</a>
 * <p>
 * Field                Type	            Description
 * update_id	        Integer	            The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
 * message 	            Message	            Optional. New incoming message of any kind — text, photo, sticker, etc.
 * edited_message	    Message	            Optional. New version of a message that is known to the bot and was edited
 * channel_post	        Message	            Optional. New incoming channel post of any kind — text, photo, sticker, etc.
 * edited_channel_post	Message	            Optional. New version of a channel post that is known to the bot and was edited
 * inline_query	        InlineQuery	        Optional. New incoming inline query
 * chosen_inline_result	ChosenInlineResult	Optional. The result of an inline query that was chosen by a user and sent to their chat partner. Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
 * callback_query	    CallbackQuery	    Optional. New incoming callback query
 * shipping_query	    ShippingQuery	    Optional. New incoming shipping query. Only for invoices with flexible price
 * pre_checkout_query	PreCheckoutQuery	Optional. New incoming pre-checkout query. Contains full information about checkout
 */

@Data
public class Update {
    @JsonProperty("update_id")
    private Long updateId;

    private Message message;

    @JsonProperty("edited_message")
    private Message editedMessage;

    @JsonProperty("channel_post")
    private Message channelPost;

    @JsonProperty("edited_channel_post")
    private Message editedChannelPost;

    @JsonProperty("inline_query")
    private InlineQuery inlineQuery;

    @JsonProperty("chosen_inline_result")
    private ChosenInlineResult chosenInlineResult;

    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;

    @JsonProperty("shipping_query")
    private ShippingQuery shippingQuery;

    @JsonProperty("pre_checkout_query")
    private PreCheckoutQuery preCheckoutQuery;
}
