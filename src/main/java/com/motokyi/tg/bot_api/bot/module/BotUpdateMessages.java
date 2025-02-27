package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.method.EditMessageReplyMarkup;
import com.motokyi.tg.bot_api.api.method.EditMessageText;
import com.motokyi.tg.bot_api.api.type.message.Message;
import org.jetbrains.annotations.NotNull;

/** Interface defines bot operations related to update Messages */
public interface BotUpdateMessages {
    EditMessageText editMessageText(@NotNull Message message);

    EditMessageText editMessageText(@NotNull Long chatId, @NotNull Long messageId);

    EditMessageReplyMarkup editMessageReplyMarkup(@NotNull Message message);

    EditMessageReplyMarkup editMessageReplyMarkup(@NotNull Long chatId, @NotNull Long messageId);
}
