package com.motokyi.tg.bot_api.api.method.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Use this method to receive incoming updates using long polling. An Array of Update objects is returned.
 * See <a href="GetUpdates">https://core.telegram.org/bots/api#getupdates</a>
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUpdates {
    private Long offset;

    private Integer limit;

    private Integer timeout;

    @JsonProperty("allowed_updates")
    private List<String> allowedUpdates;
}