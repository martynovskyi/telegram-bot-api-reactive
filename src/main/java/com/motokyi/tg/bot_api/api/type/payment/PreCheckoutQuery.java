package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object contains information about an incoming pre-checkout query.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#precheckoutquery">PreCheckoutQuery</a>
 */
@Data
public class PreCheckoutQuery {
    private String id;

    private User from;

    private String currency;

    @JsonProperty(ApiProperties.TOTAL_AMOUNT)
    private Integer totalAmount;

    @JsonProperty(ApiProperties.INVOICE_PAYLOAD)
    private String invoicePayload;

    @JsonProperty("shipping_option_id")
    private String shippingOptionId;

    @JsonProperty("order_info")
    private OrderInfo orderInfo;
}
