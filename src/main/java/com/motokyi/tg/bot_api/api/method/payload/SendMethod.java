package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class SendMethod {

    @JsonProperty(ApiProperties.CHAT_ID)
    protected String chatId;

    @JsonProperty(ApiProperties.PARSE_MODE)
    protected String parseMode;

    @JsonProperty(ApiProperties.DISABLE_WEB_PAGE_PREVIEW)
    protected Boolean disableWebPagePreview;

    @JsonProperty(ApiProperties.DISABLE_NOTIFICATION)
    protected Boolean disableNotification;

    @JsonProperty(ApiProperties.REPLY_TO_MESSAGE_ID)
    protected Long replyToMessageId;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    protected KeyboardMarkup replyMarkup;

    SendMethod(String chatId) {
        this.chatId = chatId;
    }
}
