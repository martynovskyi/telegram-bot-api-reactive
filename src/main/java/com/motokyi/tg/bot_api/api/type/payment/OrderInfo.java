package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents information about an order.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#orderinfo">OrderInfo</a>
 */
@Data
public class OrderInfo {

    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @JsonProperty(ApiProperties.SHIPPING_ADDRESS)
    private ShippingAddress shippingAddress;
}
