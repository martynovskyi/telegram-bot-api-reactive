package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a venue.
 * See <a href="Venue">https://core.telegram.org/bots/api#venue</a>
 * <p>
 * Field	        Type	    Description
 * location	        Location	Venue location
 * title	        String	    Name of the venue
 * address	        String	    Address of the venue
 * foursquare_id	String	    Optional. Foursquare identifier of the venue
 */
@Data
public class Venue {

    private Location location;

    private String title;

    private String address;

    @JsonProperty("foursquareId")
    private String foursquareId;

}
