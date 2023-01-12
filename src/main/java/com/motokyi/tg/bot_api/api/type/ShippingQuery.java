package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This object contains information about an incoming shipping query.
 * See <a href="ShippingQuery">https://core.telegram.org/bots/api#shippingquery</a>
 * <p>
 * Field            Type              Description
 * id	            String	          Unique query identifier
 * from	            User	          User who sent the query
 * invoice_payload	String	          Bot specified invoice payload
 * shipping_address	ShippingAddress	  User specified shipping address
 */
@Data
@JsonInclude(NON_NULL)
public class ShippingQuery {

    private String id;

    private User from;

    @JsonProperty("invoice_payload")
    private String invoicePayload;

    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

}
