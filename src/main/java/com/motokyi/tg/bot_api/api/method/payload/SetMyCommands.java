package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.motokyi.tg.bot_api.api.constant.ApiProperties.LANGUAGE_CODE;

/**
 * Use this method to change the list of the bot's commands.
 * See <a href="https://core.telegram.org/bots#commands">here</a> for more details about bot commands. Returns True on success.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#setmycommands">setMyCommands</a>
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetMyCommands {

    private List<BotCommand> commands = new ArrayList<>();

    private BotCommandScope scope;

    @JsonProperty(LANGUAGE_CODE)
    private String languageCode;
}
