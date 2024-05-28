package com.motokyi.tg.bot_api.api.type.command;

/**
 * This object represents the scope to which bot commands are applied.
 * <ul>Currently, the following 7 scopes are supported:
 * <li>BotCommandScopeDefault
 * <li>BotCommandScopeAllPrivateChats
 * <li>BotCommandScopeAllGroupChats
 * <li>BotCommandScopeAllChatAdministrators
 * <li>BotCommandScopeChat
 * <li>BotCommandScopeChatAdministrators
 * <li>BotCommandScopeChatMember
 * </ul>
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#botcommandscope">BotCommandScope</a>
 */
public class BotCommandScopes {
    public static final BotCommandScope DEFAULT = new BotCommandScope("default");
    public static final BotCommandScope ALL_PRIVATE_CHATS = new BotCommandScope("all_private_chats");
    public static final BotCommandScope ALL_GROUP_CHATS = new BotCommandScope("all_group_chats");
    public static final BotCommandScope ALL_CHAT_ADMINISTRATORS = new BotCommandScope("all_chat_administrators");

    public static BotCommandScopeChat chat(String chatId) {
        return new BotCommandScopeChat("chat", chatId);
    }

    public static BotCommandScopeChat chatAdministrators(String chatId) {
        return new BotCommandScopeChat("chat_administrators", chatId);
    }

    public static BotCommandScopeChatMember ChatMember(String chatId, Integer userId) {
        return new BotCommandScopeChatMember("chat_member", chatId, userId);
    }
}
