package com.motokyi.tg.bot_api.api.type.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the scope of bot commands, covering a specific chat.
 * <p>
 * See <a href="BotCommandScopeChat">https://core.telegram.org/bots/api#botcommandscopechat</a>
 * <p>
 *
 * @version Bot API 6.9
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
