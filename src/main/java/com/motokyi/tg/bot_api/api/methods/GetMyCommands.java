package com.motokyi.tg.bot_api.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.Response;
import com.motokyi.tg.bot_api.api.types.command.BotCommand;
import com.motokyi.tg.bot_api.api.types.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user language.
 * Returns Array of BotCommand on success. If commands aren't set, an empty list is returned.
 * See <a href="GetMyCommands">https://core.telegram.org/bots/api#getmycommands</a>
 */

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMyCommands extends BotMethod<Response<List<BotCommand>>> {

    private BotCommandScope scope;

    @JsonProperty("language_code")
    private String languageCode;

    public GetMyCommands(BotApiClient client) {
        super(client);
    }

    @Override
    public Mono<Response<List<BotCommand>>> send() {
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<List<BotCommand>>> consumer) {
        return client.send(this).subscribe(consumer);
    }

    public GetMyCommands setScope(BotCommandScope scope) {
        this.scope = scope;
        return this;
    }

    public GetMyCommands setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }
}
