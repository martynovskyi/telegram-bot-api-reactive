package com.motokyi.tg.bot_api.api.type.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import java.util.List;
import lombok.Data;

/**
 * This object contains information about the quoted part of a message that is replied to by the
 * given message.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#textquote">TextQuote</a>
 */
@Data
public class TextQuote {

    private String text;

    private List<MessageEntity> entities;

    private Integer position;

    @JsonProperty(ApiProperties.IS_MANUAL)
    private Boolean isManual;
}
