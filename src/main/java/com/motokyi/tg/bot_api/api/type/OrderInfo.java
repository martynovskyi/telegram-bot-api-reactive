package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents information about an order.
 * See <a href="OrderInfo">https://core.telegram.org/bots/api#orderinfo</a>
 * <p>
 * Field	        Type            Description
 * name	            String	        Optional. User name
 * phone_number	    String	        Optional. User's phone number
 * email	        String	        Optional. User email
 * shipping_address	ShippingAddress	Optional. User shipping address
 */
@Data
public class OrderInfo {

    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;
}
