package com.motokyi.tg.botapi.api.types.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BotCommandScopeChatMember extends BotCommandScopeChat {
    @JsonProperty("user_id")
    private Integer userId;

    public BotCommandScopeChatMember(String type, Integer chatId, Integer userId) {
        super(type, chatId);
        this.userId = userId;
    }
}
