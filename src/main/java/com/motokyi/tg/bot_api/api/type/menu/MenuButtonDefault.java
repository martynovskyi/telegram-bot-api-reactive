package com.motokyi.tg.bot_api.api.type.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes that no specific value for the menu button was set.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#menubuttondefault">MenuButtonDefault</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuButtonDefault extends MenuButton {}
