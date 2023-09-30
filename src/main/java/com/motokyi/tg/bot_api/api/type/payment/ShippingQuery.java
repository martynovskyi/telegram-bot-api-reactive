package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This object contains information about an incoming shipping query.
 * See <a href="ShippingQuery">https://core.telegram.org/bots/api#shippingquery</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
@JsonInclude(NON_NULL)
public class ShippingQuery {

    private String id;

    private User from;

    @JsonProperty(ApiProperties.INVOICE_PAYLOAD)
    private String invoicePayload;

    @JsonProperty(ApiProperties.SHIPPING_ADDRESS)
    private ShippingAddress shippingAddress;

}
