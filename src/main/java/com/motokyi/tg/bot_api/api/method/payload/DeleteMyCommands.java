package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 * See <a href="DeleteMyCommands">https://core.telegram.org/bots/api#deletemycommands</a>
 *
 * @version Bot API 6.8
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteMyCommands {
    public static final String LANGUAGE_CODE_PROP = "language_code";
    private BotCommandScope scope;

    @JsonProperty(LANGUAGE_CODE_PROP)
    private String languageCode;
}
