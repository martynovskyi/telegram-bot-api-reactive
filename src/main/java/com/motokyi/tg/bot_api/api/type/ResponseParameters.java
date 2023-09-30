package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Contains information about why a request was unsuccessful.
 * See <a href="ResponseParameters">https://core.telegram.org/bots/api#responseparameters</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ResponseParameters {

    @JsonProperty("migrate_to_chat_id")
    private Long migrateToChatId;

    @JsonProperty("retry_after")
    private Integer retryAfter;

}
