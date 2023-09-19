package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SetMyCommands SetMyCommands} method with the ability
 * to self-execution and chain setter
 */
@RequiredArgsConstructor
public class SetMyCommands
        extends com.motokyi.tg.bot_api.api.method.payload.SetMyCommands
        implements BotMethod<Response<Boolean>> {
    @JsonIgnore
    private final BotApiClient client;

    @Override
    public Mono<Response<Boolean>> send() {
        return client.send(this);
    }

    public SetMyCommands languageCode(String languageCode) {
        super.setLanguageCode(languageCode);
        return this;
    }

    public SetMyCommands scope(BotCommandScope scope) {
        super.setScope(scope);
        return this;
    }

    public SetMyCommands commands(List<BotCommand> commands) {
        super.setCommands(commands);
        return this;
    }
}
