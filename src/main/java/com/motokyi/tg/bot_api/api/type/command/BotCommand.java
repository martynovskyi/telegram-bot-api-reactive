package com.motokyi.tg.bot_api.api.type.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This object represents a bot command.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#botcommand">BotCommand</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotCommand {

    private String command;

    private String description;
}
