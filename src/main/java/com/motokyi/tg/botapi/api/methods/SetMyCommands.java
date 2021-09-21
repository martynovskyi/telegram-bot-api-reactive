package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.command.BotCommand;
import com.motokyi.tg.botapi.api.types.command.BotCommandScope;
import com.motokyi.tg.botapi.webclient.BotWebClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Use this method to change the list of the bot's commands.
 * See https://core.telegram.org/bots#commands for more details about bot commands. Returns True on success.
 * See <a href="SetMyCommands">https://core.telegram.org/bots/api#setmycommands</a>
 */

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetMyCommands extends BotMethod<Response<Boolean>> {

    private List<BotCommand> commands = new ArrayList<>();

    private BotCommandScope scope;
    ;

    @JsonProperty("language_code")
    private String languageCode;

    public SetMyCommands(BotWebClient client) {
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

    public SetMyCommands setCommands(List<BotCommand> commands) {
        this.commands = commands;
        return this;
    }

    public SetMyCommands setScope(BotCommandScope scope) {
        this.scope = scope;
        return this;
    }

    public SetMyCommands addCommand(BotCommand command) {
        this.commands.add(command);
        return this;
    }

    public SetMyCommands addCommand(String command, String description) {
        this.commands.add(new BotCommand(command, description));
        return this;
    }

    public SetMyCommands setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }
}
