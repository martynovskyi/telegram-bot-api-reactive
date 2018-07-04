package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a shipping address.
 * See <a href="ShippingAddress">https://core.telegram.org/bots/api#shippingaddress</a>
 * <p>
 * Field	    Type    Description
 * country_code	String	ISO 3166-1 alpha-2 country code
 * state	    String	State, if applicable
 * city	        String	City
 * street_line1	String	First line for the address
 * street_line2	String	Second line for the address
 * post_code	String	Address post code
 */
@Data
public class ShippingAddress {

    @JsonProperty("country_code")
    private String countryCode;

    private String state;

    private String city;

    @JsonProperty("street_line1")
    private String streetLine1;

    @JsonProperty("street_line2")
    private String streetLine2;

    @JsonProperty("post_code")
    private String postCode;
}
