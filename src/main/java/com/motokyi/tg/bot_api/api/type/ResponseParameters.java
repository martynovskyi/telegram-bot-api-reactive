package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Contains information about why a request was unsuccessful.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#responseparameters">ResponseParameters</a>
 */
@Data
public class ResponseParameters {

    @JsonProperty("migrate_to_chat_id")
    private Long migrateToChatId;

    @JsonProperty("retry_after")
    private Integer retryAfter;

}
