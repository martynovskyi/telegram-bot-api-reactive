package com.motokyi.tg.bot_api.api.type.menu;


import lombok.Data;

/**
 * This object describes the bot's menu button in a private chat.
 * <ul>It should be one of
 * <li> MenuButtonCommands
 * <li> MenuButtonWebApp
 * <li> MenuButtonDefault
 * </ul>
 * If a menu button other than MenuButtonDefault is set for a private chat, then it is applied in the chat.
 * Otherwise the default menu button is applied. By default, the menu button opens the list of bot commands.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#menubutton">MenuButton</a>
 */
@Data
public class MenuButton {

    private String type;
}
