package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object contains basic information about a successful payment.
 * See <a href="SuccessfulPayment">https://core.telegram.org/bots/api#successfulpayment</a>
 * <p>
 * Field	                    Type        Description
 * currency	                    String	    Three-letter ISO 4217 currency code
 * total_amount	                Integer	    Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * invoice_payload	            String	    Bot specified invoice payload
 * shipping_option_id           String	    Optional. Identifier of the shipping option chosen by the user
 * order_info	                OrderInfo	Optional. Order info provided by the user
 * telegram_payment_charge_id	String	    Telegram payment identifier
 * provider_payment_charge_id	String	    Provider payment identifier
 */
@Data
public class SuccessfulPayment {

    private String currency;

    @JsonProperty("total_amount")
    private Integer totalAmount;

    @JsonProperty("invoice_payload")
    private String invoicePayload;

    @JsonProperty("shipping_option_id")
    private String shippingOptionId;

    @JsonProperty("order_info")
    private OrderInfo orderInfo;

    @JsonProperty("telegram_payment_charge_id")
    private String telegramPaymentChargeId;

    @JsonProperty("provider_payment_charge_id")
    private String providerPaymentChargeId;

}
