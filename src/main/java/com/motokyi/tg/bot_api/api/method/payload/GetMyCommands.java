package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.command.BotCommandScope;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user language.
 * Returns Array of BotCommand on success. If commands aren't set, an empty list is returned.
 * See <a href="GetMyCommands">https://core.telegram.org/bots/api#getmycommands</a>
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMyCommands {
    private BotCommandScope scope;

    @JsonProperty("language_code")
    private String languageCode;

}
