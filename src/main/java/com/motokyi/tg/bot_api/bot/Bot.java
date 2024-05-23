package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.AnswerCallbackQuery;
import com.motokyi.tg.bot_api.api.method.EditMessageReplyMarkup;
import com.motokyi.tg.bot_api.api.method.GetUpdates;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.bot.module.*;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Convenient facade for all Bot API
 */
public interface Bot extends BotMessage, BotUpdateMessages, BotCommands, BotInfo, BotWebhook, BotMedia {
    Mono<Response<List<Update>>> getAllUpdates();

    GetUpdates getUpdates();

    Mono<Response<Chat>> getChat(@NotNull Long chatId);

    Mono<Response<Chat>> getChat(@NotNull String chatTag);

    EditMessageReplyMarkup editMessageReplyMarkup(@NotNull Long chatId, @NotNull Long messageId);

    AnswerCallbackQuery answerCallbackQuery(@NotNull String callbackQueryId);

    AnswerCallbackQuery answerCallbackQuery(CallbackQuery callbackQuery);

}
