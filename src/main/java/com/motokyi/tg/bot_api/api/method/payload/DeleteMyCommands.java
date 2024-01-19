package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import lombok.Getter;
import lombok.Setter;

import static com.motokyi.tg.bot_api.api.constant.ApiProperties.LANGUAGE_CODE;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#deletemycommands">DeleteMyCommands</a>
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteMyCommands {

    private BotCommandScope scope;

    @JsonProperty(LANGUAGE_CODE)
    private String languageCode;
}
