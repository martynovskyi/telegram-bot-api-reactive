package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This object contains information about an incoming pre-checkout query.
 * See <a href="PreCheckoutQuery">https://core.telegram.org/bots/api#precheckoutquery</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
@JsonInclude(NON_NULL)
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
