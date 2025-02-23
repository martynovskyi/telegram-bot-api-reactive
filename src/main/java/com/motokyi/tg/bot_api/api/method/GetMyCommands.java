package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import java.util.List;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.GetMyCommands GetMyCommands} method with the ability
 * to self-execution and chain setter
 */
@RequiredArgsConstructor
public class GetMyCommands extends com.motokyi.tg.bot_api.api.method.payload.GetMyCommands
        implements BotMethod<Response<List<BotCommand>>> {
    @JsonIgnore private final BotApiClient client;

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
