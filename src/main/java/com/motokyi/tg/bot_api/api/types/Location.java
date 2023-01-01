package com.motokyi.tg.bot_api.api.types;

import lombok.Data;

/**
 * This object represents a point on the map.
 * See <a href="Location">https://core.telegram.org/bots/api#location</a>
 * <p>
 * Field	    Type    Description
 * longitude	Float	Longitude as defined by sender
 * latitude  	Float	Latitude as defined by sender
 */
@Data
public class Location {
    private Double longitude;
    private Double latitude;
}
