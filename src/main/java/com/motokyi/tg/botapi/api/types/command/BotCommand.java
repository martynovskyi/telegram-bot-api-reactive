package com.motokyi.tg.botapi.api.types.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This object represents a bot command.
 * See <a href="BotCommand">https://core.telegram.org/bots/api#botcommand</a>
 * <p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotCommand {
    private String command;
    private String description;
}
