package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.botapi.webclient.BotWebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public abstract class BotMethod<T> {
    @JsonIgnore
    protected final BotWebClient client;

    protected abstract Mono<T> send();

    protected abstract Disposable subscribe(Consumer<T> consumer);

    protected BotMethod(BotWebClient client) {
        this.client = client;
    }
}
