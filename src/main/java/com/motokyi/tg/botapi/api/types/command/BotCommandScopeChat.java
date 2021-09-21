package com.motokyi.tg.botapi.api.types.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.methods.SendMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BotCommandScopeChat extends BotCommandScope {

    @JsonProperty(SendMethod.CHAT_ID)
    private Integer chatId;

    public BotCommandScopeChat(String type, Integer chatId) {
        super(type);
        this.chatId = chatId;
    }
}
