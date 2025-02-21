package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import lombok.Getter;
import lombok.Setter;

import static com.motokyi.tg.bot_api.api.constant.ApiProperties.LANGUAGE_CODE;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user language.
 * Returns Array of BotCommand on success. If commands aren't set, an empty list is returned.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#getmycommands">getMyCommands</a>
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMyCommands {
    private BotCommandScope scope;

    @JsonProperty(LANGUAGE_CODE)
    private String languageCode;

}
