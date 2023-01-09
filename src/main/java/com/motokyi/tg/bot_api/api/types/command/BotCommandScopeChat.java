package com.motokyi.tg.bot_api.api.types.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.method.payload.SendMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BotCommandScopeChat extends BotCommandScope {

    @JsonProperty(SendMethod.CHAT_ID)
    private Integer chatId;

    public BotCommandScopeChat(String type, Integer chatId) {
        super(type);
        this.chatId = chatId;
    }
}
