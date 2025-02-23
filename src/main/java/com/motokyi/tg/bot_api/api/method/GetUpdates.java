package com.motokyi.tg.bot_api.api.method;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.client.BotApiClient;
import com.motokyi.tg.bot_api.exception.TooManyRequestsException;
import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.GetUpdates GetUpdates} method with the ability to
 * self-execution and chain setter and update stream
 */
@Slf4j
@RequiredArgsConstructor
public class GetUpdates extends com.motokyi.tg.bot_api.api.method.payload.GetUpdates
        implements BotMethod<Response<List<Update>>> {
    @JsonIgnore private final BotApiClient client;

    public Mono<Response<List<Update>>> send() {
        return client.getUpdates(this);
    }

    public Flux<Update> updateStream() {
        if (isNull(super.getTimeout())) {
            super.setTimeout(50);
        }
        log.debug("Timeout {} sec", getTimeout());
        return send()
                .doOnNext(calculateOffset())
                .repeat()
                .retryWhen(
                        Retry.backoff(5, Duration.ofSeconds(super.getTimeout()))
                                .filter(throwable -> throwable instanceof TooManyRequestsException))
                .retryWhen(
                        Retry.backoff(100, Duration.ofSeconds(5))
                                .filter(throwable -> !(throwable instanceof TooManyRequestsException)))
                .map(Response::getResult)
                .flatMap(Flux::fromIterable);
    }

    private Consumer<Response<List<Update>>> calculateOffset() {
        return (Response<List<Update>> e) -> {
            super.setOffset(null);
            if (nonNull(e) && e.isOk() && !e.getResult().isEmpty()) {
                super.setOffset(e.getResult().get(e.getResult().size() - 1).getUpdateId() + 1);
            }
        };
    }
}
