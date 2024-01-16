package com.motokyi.tg.bot_api.api.type.message.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Data;

import java.util.List;

/**
 * This object contains information about the quoted part of a message that is replied to by the given message.
 * See <a href="TextQuote">https://core.telegram.org/bots/api#textquote</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class TextQuote {

    private String text;

    private List<MessageEntity> entities;

    private Integer position;

    @JsonProperty(ApiProperties.IS_MANUAL)
    private Boolean isManual;
}
