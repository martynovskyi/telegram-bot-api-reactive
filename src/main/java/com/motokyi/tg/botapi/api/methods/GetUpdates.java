package com.motokyi.tg.botapi.api.methods;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.webclient.BotClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

/**
 * Use this method to receive incoming updates using long polling. An Array of Update objects is returned.
 * See <a href="GetUpdates">https://core.telegram.org/bots/api#getupdates</a>
 */
@Slf4j
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUpdates extends BotMethod<Response<List<Update>>> {
    private Long offset;

    private Integer limit;

    private Integer timeout;

    @JsonProperty("allowed_updates")
    private List<String> allowedUpdates;

    public GetUpdates(BotClient wc) {
        super(wc);
    }

    public Mono<Response<List<Update>>> send() {
        return super.client.getUpdates(this);
    }

    public Flux<Update> updateStream() {
        if (isNull(this.timeout)) {
            this.timeout = 50;
        }
        log.debug("Timeout {} sec", timeout);
        return client.getUpdates(this)
                .doOnNext(this.calculateOffset())
                .repeat()
                .map(Response::getResult)
                .flatMap(Flux::fromIterable);

    }

    private Consumer<Response<List<Update>>> calculateOffset() {
        return (Response<List<Update>> e) -> {
            this.offset = null;
            if (e.isOk() && !e.getResult().isEmpty()) {
                this.offset = e.getResult().get(e.getResult().size() - 1).getUpdateId() + 1;
            }
        };
    }

    public Disposable subscribe(Consumer<Response<List<Update>>> consumer) {
        return client.getUpdates(this).subscribe(consumer);
    }

    public GetUpdates setOffset(Long offset) {
        this.offset = offset;
        return this;
    }

    public GetUpdates setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public GetUpdates setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public GetUpdates setAllowedUpdates(List<String> allowedUpdates) {
        this.allowedUpdates = allowedUpdates;
        return this;
    }
}
