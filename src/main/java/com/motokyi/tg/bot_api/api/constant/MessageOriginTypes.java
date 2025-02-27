package com.motokyi.tg.bot_api.api.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageOriginTypes {
    public static final String USER = "user";
    public static final String HIDDEN_USER = "hidden_user";
    public static final String CHAT = "chat";
    public static final String CHANNEL = "channel";
}
