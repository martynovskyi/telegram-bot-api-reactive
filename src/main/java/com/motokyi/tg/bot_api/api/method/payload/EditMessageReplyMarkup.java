package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.types.markup.KeyboardMarkup;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to edit only the reply markup of messages.
 * On success, if the edited message is not an inline message, the edited Message is returned, otherwise True is returned.
 * See <a href="EditMessageReplyMarkup">https://core.telegram.org/bots/api#editmessagereplymarkup</a>
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageReplyMarkup {
    @JsonProperty(SendMethod.CHAT_ID)
    private String chatId;

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("inline_message_id")
    private String inlineMessageId;

    @JsonProperty(SendMethod.REPLY_MARKUP)
    private KeyboardMarkup replyMarkup;

    public EditMessageReplyMarkup(String chatId, String messageId) {
        this.chatId = chatId;
        this.messageId = messageId;
    }
}
