package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.GetUpdates;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.bot.module.*;
import java.util.List;
import reactor.core.publisher.Mono;

/** Convenient facade for all Bot API */
public interface Bot
        extends BotMessage,
                BotUpdateMessages,
                BotCommands,
                BotInfo,
                BotWebhook,
                BotMedia,
                CallbackQuery,
                Chat {
    Mono<Response<List<Update>>> getAllUpdates();

    GetUpdates getUpdates();
}
