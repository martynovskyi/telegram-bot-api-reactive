package com.motokyi.tg.bot_api.api.type.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the scope of bot commands, covering a specific chat.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechatmember">BotCommandScopeChatMember</a>
 */
@Getter
@Setter
@NoArgsConstructor
public class BotCommandScopeChatMember extends BotCommandScopeChat {

    @JsonProperty(ApiProperties.USER_ID)
    private Integer userId;

    public BotCommandScopeChatMember(String type, String chatId, Integer userId) {
        super(type, chatId);
        this.userId = userId;
    }
}
