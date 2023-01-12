package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteMyCommands
        extends com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands
        implements BotMethod<Response<Boolean>> {

    @JsonIgnore
    private final BotApiClient client;

    @Override
    public Mono<Response<Boolean>> send() {
        return client.send(this);
    }

    public DeleteMyCommands scope(BotCommandScope scope) {
        super.setScope(scope);
        return this;
    }

    public DeleteMyCommands languageCode(String languageCode) {
        super.setLanguageCode(languageCode);
        return this;
    }
}
