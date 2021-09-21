package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.command.BotCommandScope;
import com.motokyi.tg.botapi.webclient.BotWebClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 * See <a href="DeleteMyCommands">https://core.telegram.org/bots/api#deletemycommands</a>
 */

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteMyCommands extends BotMethod<Response<Boolean>> {

    BotCommandScope scope;

    @JsonProperty("language_code")
    private String languageCode;

    public DeleteMyCommands(BotWebClient client) {
        super(client);
    }

    @Override
    public Mono<Response<Boolean>> send() {
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Boolean>> consumer) {
        return client.send(this).subscribe(consumer);
    }

    public DeleteMyCommands setScope(BotCommandScope scope) {
        this.scope = scope;
        return this;
    }

    public DeleteMyCommands setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }
}
