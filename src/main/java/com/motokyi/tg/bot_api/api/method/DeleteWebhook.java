package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

public class DeleteWebhook
        extends com.motokyi.tg.bot_api.api.method.payload.DeleteWebhook
        implements BotMethod<Response<Boolean>> {
    @JsonIgnore
    private final BotApiClient client;

    public DeleteWebhook(BotApiClient client) {
        this.client = client;
    }

    @Override
    public Mono<Response<Boolean>> send() {
        return client.send(this);
    }
}
