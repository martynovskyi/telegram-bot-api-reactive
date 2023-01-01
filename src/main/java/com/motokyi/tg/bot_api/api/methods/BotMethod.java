package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public abstract class BotMethod<T> {
    @JsonIgnore
    protected final BotApiClient client;

    protected abstract Mono<T> send();

    protected abstract Disposable subscribe(Consumer<T> consumer);

    protected BotMethod(BotApiClient client) {
        this.client = client;
    }
}
