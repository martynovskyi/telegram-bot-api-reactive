package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.botapi.webclient.TGBotWebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public abstract class TGApiMethod<T> {
    @JsonIgnore
    protected final TGBotWebClient wc;

    protected abstract Mono<?> send();

    protected abstract Disposable subscribe(Consumer<T> consumer);

    protected TGApiMethod(TGBotWebClient wc) {
        this.wc = wc;
    }
}
