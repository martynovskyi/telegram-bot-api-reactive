package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.method.AnswerCallbackQuery;
import com.motokyi.tg.bot_api.api.type.Response;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/** Interface defines bot operations related to Message */
public interface CallbackQuery {

    AnswerCallbackQuery answerCallbackQuery(@NotNull String callbackQueryId);

    Mono<Response<Boolean>> answerCallbackQuery(@NotNull String callbackQueryId, String text);

    AnswerCallbackQuery answerCallbackQuery(
            com.motokyi.tg.bot_api.api.type.markup.CallbackQuery callbackQuery);

    Mono<Response<Boolean>> answerCallbackQuery(
            com.motokyi.tg.bot_api.api.type.markup.CallbackQuery callbackQuery, String text);
}
