package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.command.BotCommand;
import com.motokyi.tg.bot_api.api.types.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class GetMyCommands
        extends com.motokyi.tg.bot_api.api.method.payload.GetMyCommands
        implements BotMethod<Response<List<BotCommand>>> {
    @JsonIgnore
    private final BotApiClient client;

    @Override
    public Mono<Response<List<BotCommand>>> send() {
        return client.send(this);
    }

    public GetMyCommands scope(BotCommandScope scope) {
        super.setScope(scope);
        return this;
    }

    public GetMyCommands languageCode(String languageCode) {
        super.setLanguageCode(languageCode);
        return this;
    }
}
