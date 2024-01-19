package com.motokyi.tg.bot_api.api.type.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This object represents the scope to which bot commands are applied.
 *
 * <ul> Currently, the following 7 scopes are supported:
 * <li> BotCommandScopeDefault
 * <li> BotCommandScopeAllPrivateChats
 * <li> BotCommandScopeAllGroupChats
 * <li> BotCommandScopeAllChatAdministrators
 * <li> BotCommandScopeChat
 * <li> BotCommandScopeChatAdministrators
 * <li> BotCommandScopeChatMember
 * </ul>
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#botcommandscope">BotCommandScope</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotCommandScope {
    private String type;
}
