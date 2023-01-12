package com.motokyi.tg.bot_api.api.constant;

public final class UpdateType {
    public static final String MESSAGE = "message";
    public static final String EDITED_MESSAGE = "edited_message";
    public static final String CHANNEL_POST = "channel_post";
    public static final String EDITED_CHANNEL_POST = "edited_channel_post";
    public static final String INLINE_QUERY = "inline_query";
    public static final String CHOSEN_INLINE_RESULT = "chosen_inline_result";
    public static final String CALLBACK_QUERY = "callback_query";
    public static final String SHIPPING_QUERY = "shipping_query";
    public static final String PRE_CHECKOUT_QUERY = "pre_checkout_query";
    public static final String POLL = "poll";
    public static final String POLL_ANSWER = "poll_answer";
    public static final String MY_CHAT_MEMBER = "my_chat_member";
    public static final String CHAT_MEMBER = "chat_member";
    public static final String CHAT_JOIN_REQUEST = "chat_join_request";

    private UpdateType() {
    }
}
