package com.motokyi.tg.bot_api.api.type.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a menu button, which opens the bot's list of commands.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#menubuttoncommands">MenuButtonCommands</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuButtonCommands extends MenuButton {}
