package com.motokyi.tg.bot_api.api.type.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import java.util.List;
import lombok.Data;

/**
 * Describes the opening hours of a business.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#businessopeninghours">BusinessOpeningHours</a>
 */
@Data
public class BusinessOpeningHours {
    @JsonProperty(ApiProperties.TIME_ZONE_NAME)
    private String timeZoneName;

    @JsonProperty(ApiProperties.OPENING_HOURS)
    private List<BusinessOpeningHoursInterval> openingHours;
}
