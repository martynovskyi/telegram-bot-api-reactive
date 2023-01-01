package com.motokyi.tg.bot_api.api.types.command;

/**
 * This object represents the scope to which bot commands are applied.
 * Currently, the following 7 scopes are supported:
 * BotCommandScopeDefault
 * BotCommandScopeAllPrivateChats
 * BotCommandScopeAllGroupChats
 * BotCommandScopeAllChatAdministrators
 * BotCommandScopeChat
 * BotCommandScopeChatAdministrators
 * BotCommandScopeChatMember
 * <p>
 * See <a href="BotCommandScope">https://core.telegram.org/bots/api#botcommandscope</a>
 * <p>
 */
public class BotCommandScopes {
    public static final BotCommandScope DEFAULT = new BotCommandScope("default");
    public static final BotCommandScope ALL_PRIVATE_CHATS = new BotCommandScope("all_private_chats");
    public static final BotCommandScope ALL_GROUP_CHATS = new BotCommandScope("all_group_chats");
    public static final BotCommandScope ALL_CHAT_ADMINISTRATORS = new BotCommandScope("all_chat_administrators");

    public static BotCommandScopeChat chat(Integer chatId) {
        return new BotCommandScopeChat("chat", chatId);
    }

    public static BotCommandScopeChat chatAdministrators(Integer chatId) {
        return new BotCommandScopeChat("chat_administrators", chatId);
    }

    public static BotCommandScopeChatMember ChatMember(Integer chatId, Integer userId) {
        return new BotCommandScopeChatMember("chat_member", chatId, userId);
    }
}
