package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a shipping address.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#shippingaddress">ShippingAddress</a>
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
