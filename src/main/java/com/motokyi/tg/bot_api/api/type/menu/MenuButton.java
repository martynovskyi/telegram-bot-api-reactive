package com.motokyi.tg.bot_api.api.type.menu;


import lombok.Data;

/**
 * This object describes the bot's menu button in a private chat. It should be one of
 * <li> MenuButtonCommands
 * <li> MenuButtonWebApp
 * <li> MenuButtonDefault
 * <p>
 * If a menu button other than MenuButtonDefault is set for a private chat, then it is applied in the chat.
 * Otherwise the default menu button is applied. By default, the menu button opens the list of bot commands.
 * <p>
 * See <a href="MenuButton">https://core.telegram.org/bots/api#menubutton</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class MenuButton {

    private String type;
}
