package com.motokyi.tg.bot_api.api.method.payload;

import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;

public interface SendMethod {
    String getChatId();

    String getMessageThreadId();

    String getParseMode();

    Boolean getDisableNotification();

    Boolean getProtectContent();

    ReplyParameters getReplyParameters();

    KeyboardMarkup getReplyMarkup();
}
