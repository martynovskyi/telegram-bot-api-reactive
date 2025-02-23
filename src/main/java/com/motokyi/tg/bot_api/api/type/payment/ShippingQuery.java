package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object contains information about an incoming shipping query.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#shippingquery">ShippingQuery</a>
 */
@Data
public class ShippingQuery {

    private String id;

    private User from;

    @JsonProperty(ApiProperties.INVOICE_PAYLOAD)
    private String invoicePayload;

    @JsonProperty(ApiProperties.SHIPPING_ADDRESS)
    private ShippingAddress shippingAddress;
}
