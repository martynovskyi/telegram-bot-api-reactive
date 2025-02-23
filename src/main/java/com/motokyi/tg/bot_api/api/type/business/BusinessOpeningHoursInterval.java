package com.motokyi.tg.bot_api.api.type.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Describes an interval of time during which a business is open.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#businessopeninghoursinterval">BusinessOpeningHoursInterval</a>
 */
@Data
public class BusinessOpeningHoursInterval {
    @JsonProperty(ApiProperties.OPENING_MINUTE)
    private Integer openingMinute;

    @JsonProperty(ApiProperties.CLOSING_MINUTE)
    private Integer closingMinute;
}
