package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a point on the map.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#location">Location</a>
 */
@Data
public class Location {

    private Double longitude;

    private Double latitude;

    @JsonProperty("horizontal_accuracy")
    private Double horizontalAccuracy;

    @JsonProperty("live_period")
    private Integer livePeriod;

    private Integer heading;

    @JsonProperty("proximity_alert_radius")
    private Integer proximityAlertRadius;

}
