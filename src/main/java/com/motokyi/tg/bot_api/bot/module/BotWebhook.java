package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.method.DeleteWebhook;
import com.motokyi.tg.bot_api.api.method.SetWebhook;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.WebhookInfo;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/**
 * Interface defines bot operations related to Webhooks
 */
public interface BotWebhook {
    SetWebhook setWebhook(@NotNull String url);

    DeleteWebhook deleteWebhook();

    Mono<Response<WebhookInfo>> getWebhookInfo();
}
