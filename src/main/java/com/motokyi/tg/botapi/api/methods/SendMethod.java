package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.botapi.webclient.BotClient;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class SendMethod<T> extends BotMethod<T> {

    public static final String CHAT_ID = "chat_id";
    public static final String PARSE_MODE = "parse_mode";
    public static final String DISABLE_WEB_PAGE_PREVIEW = "disable_web_page_preview";
    public static final String DISABLE_NOTIFICATION = "disable_notification";
    public static final String REPLY_TO_MESSAGE_ID = "reply_to_message_id";
    public static final String REPLY_MARKUP = "reply_markup";

    @JsonProperty(CHAT_ID)
    protected String chatId;

    @JsonProperty(PARSE_MODE)
    protected String parseMode;

    @JsonProperty(DISABLE_WEB_PAGE_PREVIEW)
    protected Boolean disableWebPagePreview;

    @JsonProperty(DISABLE_NOTIFICATION)
    protected Boolean disableNotification;

    @JsonProperty(REPLY_TO_MESSAGE_ID)
    protected Long replyToMessageId;

    @JsonProperty(REPLY_MARKUP)
    protected KeyboardMarkup replyMarkup;

    SendMethod(String chatId, BotClient wc) {
        super(wc);
        this.chatId = chatId;
    }
}
