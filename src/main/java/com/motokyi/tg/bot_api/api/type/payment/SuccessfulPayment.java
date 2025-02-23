package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object contains basic information about a successful payment.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#successfulpayment">SuccessfulPayment</a>
 */
@Data
public class SuccessfulPayment {

    private String currency;

    @JsonProperty(ApiProperties.TOTAL_AMOUNT)
    private Integer totalAmount;

    @JsonProperty(ApiProperties.INVOICE_PAYLOAD)
    private String invoicePayload;

    @JsonProperty("subscription_expiration_date")
    private Integer subscriptionExpirationDate;

    @JsonProperty("is_recurring")
    private Boolean isRecurring;

    @JsonProperty("is_first_recurring")
    private Boolean isFirstRecurring;

    @JsonProperty("shipping_option_id")
    private String shippingOptionId;

    @JsonProperty("order_info")
    private OrderInfo orderInfo;

    @JsonProperty("telegram_payment_charge_id")
    private String telegramPaymentChargeId;

    @JsonProperty("provider_payment_charge_id")
    private String providerPaymentChargeId;
}
