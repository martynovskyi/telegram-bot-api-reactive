package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to receive incoming updates using long polling. An Array of Update objects is
 * returned.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#getupdates">GetUpdates</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUpdates {
    private Long offset;

    private Integer limit;

    private Integer timeout;

    @JsonProperty(ApiProperties.ALLOWED_UPDATES)
    private List<String> allowedUpdates;
}
