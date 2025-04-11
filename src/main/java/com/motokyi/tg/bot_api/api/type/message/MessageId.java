package com.motokyi.tg.bot_api.api.type.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

@Data
public class MessageId {
    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;
}
