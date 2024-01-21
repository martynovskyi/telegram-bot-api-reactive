package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a venue.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#venue">Venue</a>
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
