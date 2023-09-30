package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a venue.
 * See <a href="Venue">https://core.telegram.org/bots/api#venue</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class Venue {

    private Location location;

    private String title;

    private String address;

    @JsonProperty("foursquare_id")
    private String foursquareId;

    @JsonProperty("foursquare_type")
    private String foursquareType;

    @JsonProperty("google_place_id")
    private String googlePlaceId;

    @JsonProperty("google_place_type")
    private String googlePlaceType;

}
