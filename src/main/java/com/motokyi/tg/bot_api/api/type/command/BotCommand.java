package com.motokyi.tg.bot_api.api.type.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This object represents a bot command.
 * See <a href="BotCommand">https://core.telegram.org/bots/api#botcommand</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotCommand {
    private String command;
    private String description;
}
