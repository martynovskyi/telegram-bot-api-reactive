package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.markup.KeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.List;

/**
 * Use this method to send general files. On success, the sent Message is returned.
 * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#senddocument">sendDocument</a>
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendDocument implements SendMethod {
    public static final String DOCUMENT_ID = "document";

    @JsonProperty(ApiProperties.BUSINESS_CONNECTION_ID)
    private String businessConnectionId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private String chatId;

    @JsonProperty(ApiProperties.MESSAGE_THREAD_ID)
    private String messageThreadId;

    @JsonIgnore
    private File documentFile;

    @JsonProperty(DOCUMENT_ID)
    private String documentId;

    @JsonIgnore
    private File thumbnailFile;

    private String thumbnail;

    private String caption;

    @JsonProperty(ApiProperties.PARSE_MODE)
    private String parseMode;

    @JsonProperty(ApiProperties.CAPTION_ENTITIES)
    private List<MessageEntity> captionEntities;

    @JsonProperty("disable_content_type_detection")
    private Boolean disableContentTypeDetection;

    @JsonProperty(ApiProperties.DISABLE_NOTIFICATION)
    private Boolean disableNotification;

    @JsonProperty(ApiProperties.PROTECT_CONTENT)
    private Boolean protectContent;

    @JsonProperty(ApiProperties.ALLOW_PAID_BROADCAST)
    private Boolean allowPaidBroadcast;

    @JsonProperty(ApiProperties.MESSAGE_EFFECT_ID)
    private String messageEffectId;

    @JsonProperty(ApiProperties.REPLY_PARAMETERS)
    private ReplyParameters replyParameters;

    @JsonProperty(ApiProperties.REPLY_MARKUP)
    private KeyboardMarkup replyMarkup;

    public SendDocument(String chatId) {
        this.chatId = chatId;
    }
}
