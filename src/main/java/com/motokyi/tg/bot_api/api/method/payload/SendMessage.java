package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.LinkPreviewOptions;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#sendmessage">SendMessage</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessage extends SendMethod {

    private String text;

    @JsonProperty(ApiProperties.LINK_PREVIEW_OPTIONS)
    private LinkPreviewOptions linkPreviewOptions;

    private List<MessageEntity> entities;

    public SendMessage(String chatId) {
        super(chatId);
    }
}
