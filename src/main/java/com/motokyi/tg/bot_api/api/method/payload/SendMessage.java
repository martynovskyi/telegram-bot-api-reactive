package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 * See <a href="SendMessage">https://core.telegram.org/bots/api#sendmessage</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessage extends SendMethod {
    public static final String TEXT = "text";

    private String text;

    public SendMessage(String chatId) {
        super(chatId);
    }
}
