package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.command.BotCommand;
import com.motokyi.tg.bot_api.api.types.command.BotCommandScope;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Use this method to change the list of the bot's commands.
 * See https://core.telegram.org/bots#commands for more details about bot commands. Returns True on success.
 * See <a href="SetMyCommands">https://core.telegram.org/bots/api#setmycommands</a>
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetMyCommands {

    private List<BotCommand> commands = new ArrayList<>();

    private BotCommandScope scope;

    @JsonProperty("language_code")
    private String languageCode;
}
