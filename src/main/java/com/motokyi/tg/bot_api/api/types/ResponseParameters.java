package com.motokyi.tg.bot_api.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Contains information about why a request was unsuccessful.
 * See <a href="ResponseParameters">https://core.telegram.org/bots/api#responseparameters</a>
 * <p>
 * Field                Type	  Description
 * migrate_to_chat_id	Integer	  Optional. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * retry_after	        Integer   Optional. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
 */
@Data
public class ResponseParameters {

    @JsonProperty("migrate_to_chat_id")
    private Long migrateToChatId;

    @JsonProperty("retry_after")
    private Integer retryAfter;

}
