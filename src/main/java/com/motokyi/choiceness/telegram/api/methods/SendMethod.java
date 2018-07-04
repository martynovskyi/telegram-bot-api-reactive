package com.motokyi.choiceness.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class SendMethod {

    public static final String CHAT_ID = "chat_id";
    public static final String PARSE_MODE = "parse_mode";
    public static final String DISABLE_WEB_PAGE_PREVIEW = "disable_web_page_preview";
    public static final String DISABLE_NOTIFICATION = "disable_notification";
    public static final String REPLY_TO_MESSAGE_ID = "reply_to_message_id";
    public static final String REPLY_MARKUP = "reply_markup";
    @JsonProperty(CHAT_ID)
    private String chatId;

    @JsonProperty(PARSE_MODE)
    private String parseMode;

    @JsonProperty(DISABLE_WEB_PAGE_PREVIEW)
    private Boolean disableWebPagePreview;

    @JsonProperty(DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    @JsonProperty(REPLY_TO_MESSAGE_ID)
    private Long replyToMessageId;

    @JsonProperty(REPLY_MARKUP)
    private String replyMarkup;
}
