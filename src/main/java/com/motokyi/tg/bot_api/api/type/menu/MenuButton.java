package com.motokyi.tg.bot_api.api.type.menu;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.MenuButtonTypes;
import lombok.Data;

/**
 * This object describes the bot's menu button in a private chat.
 *
 * <ul>
 *   It should be one of
 *   <li>MenuButtonCommands
 *   <li>MenuButtonWebApp
 *   <li>MenuButtonDefault
 * </ul>
 *
 * If a menu button other than MenuButtonDefault is set for a private chat, then it is applied in
 * the chat. Otherwise the default menu button is applied. By default, the menu button opens the
 * list of bot commands.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#menubutton">MenuButton</a>
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MenuButtonCommands.class, name = MenuButtonTypes.COMMANDS),
    @JsonSubTypes.Type(value = MenuButtonWebApp.class, name = MenuButtonTypes.WEB_APP),
    @JsonSubTypes.Type(value = MenuButtonDefault.class, name = MenuButtonTypes.DEFAULT)
})
public abstract class MenuButton {
    private String type;
}
