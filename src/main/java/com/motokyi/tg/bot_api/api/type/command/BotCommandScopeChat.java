package com.motokyi.tg.bot_api.api.type.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the scope of bot commands, covering a specific chat.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechat">BotCommandScopeChat</a>
 */
@Getter
@Setter
@NoArgsConstructor
public class BotCommandScopeChat extends BotCommandScope {

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    public BotCommandScopeChat(String type, String chatId) {
        super(type);
        this.chatId = chatId;
    }
}
