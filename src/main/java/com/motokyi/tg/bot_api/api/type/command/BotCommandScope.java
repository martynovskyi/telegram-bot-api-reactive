package com.motokyi.tg.bot_api.api.type.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This object represents the scope to which bot commands are applied.
 * See <a href="BotCommandScope">https://core.telegram.org/bots/api#botcommandscope</a>
 * <p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotCommandScope {
    private String type;
}