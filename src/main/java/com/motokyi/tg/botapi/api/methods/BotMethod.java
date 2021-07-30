package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.botapi.webclient.BotClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public abstract class BotMethod<T> {
    @JsonIgnore
    protected final BotClient client;

    protected abstract Mono<?> send();

    protected abstract Disposable subscribe(Consumer<T> consumer);

    protected BotMethod(BotClient client) {
        this.client = client;
    }
}
