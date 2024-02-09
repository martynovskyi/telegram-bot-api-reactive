package com.motokyi.tg.bot_api.api.method;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

import java.util.function.Consumer;

public interface BotMethod<T> {
    Mono<T> send();

    default Disposable subscribe() {
        return send().subscribe();
    }

    default Disposable subscribe(Consumer<? super T> consumer) {
        return send().subscribe(consumer);
    }

    default void subscribe(Subscriber<? super T> actual) {
        send().subscribe(actual);
    }

    default Disposable subscribe(@Nullable Consumer<? super T> consumer,
                                 Consumer<? super Throwable> errorConsumer) {
        return send().subscribe(consumer, errorConsumer);
    }

    default Disposable subscribe(@Nullable Consumer<? super T> consumer,
                                 @Nullable Consumer<? super Throwable> errorConsumer,
                                 @Nullable Runnable completeConsumer) {
        return send().subscribe(consumer, errorConsumer, completeConsumer);
    }

    default Disposable subscribe(@Nullable Consumer<? super T> consumer,
                                 @Nullable Consumer<? super Throwable> errorConsumer,
                                 @Nullable Runnable completeConsumer,
                                 @Nullable Consumer<? super Subscription> subscriptionConsumer) {
        return send().subscribe(consumer, errorConsumer, completeConsumer, subscriptionConsumer);
    }

    default Disposable subscribe(@Nullable Consumer<? super T> consumer,
                                 @Nullable Consumer<? super Throwable> errorConsumer,
                                 @Nullable Runnable completeConsumer,
                                 @Nullable Context initialContext) {
        return send().subscribe(consumer, errorConsumer, completeConsumer, initialContext);
    }
}

