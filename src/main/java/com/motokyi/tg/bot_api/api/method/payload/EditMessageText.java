package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.LinkPreviewOptions;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to edit text and game messages. On success, if the edited message is not an
 * inline message, the edited Message is returned, otherwise True is returned.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#editmessagetext">editMessageText</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageText {

    @JsonProperty(ApiProperties.BUSINESS_CONNECTION_ID)
    private String businessConnectionId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private String messageId;

    @JsonProperty(ApiProperties.INLINE_MESSAGE_ID)
    private String inlineMessageId;

    @JsonProperty(ApiProperties.TEXT)
    private String text;

    @JsonProperty(ApiProperties.PARSE_MODE)
    private String parseMode;

    @JsonProperty(ApiProperties.ENTITIES)
    private List<MessageEntity> entities;

    @JsonProperty(ApiProperties.LINK_PREVIEW_OPTIONS)
    private LinkPreviewOptions linkPreviewOptions;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    private KeyboardMarkup replyMarkup;

    public EditMessageText(String chatId, String messageId) {
        this.chatId = chatId;
        this.messageId = messageId;
    }
}
