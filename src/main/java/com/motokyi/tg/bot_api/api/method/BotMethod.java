package com.motokyi.tg.bot_api.api.method;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public interface BotMethod<T> {
    Mono<T> send();

    default Disposable subscribe(Consumer<T> consumer) {
        return send().subscribe(consumer);
    }
}
