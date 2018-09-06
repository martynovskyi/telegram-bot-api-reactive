package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This object contains information about an incoming pre-checkout query.
 * See <a href="PreCheckoutQuery">https://core.telegram.org/bots/api#precheckoutquery</a>
 * <p>
 * Field                Type        Description
 * id	                String	    Unique query identifier
 * from	                User	    User who sent the query
 * currency	            String	    Three-letter ISO 4217 currency code
 * total_amount	        Integer	    Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * invoice_payload	    String	    Bot specified invoice payload
 * shipping_option_id	String	    Optional. Identifier of the shipping option chosen by the user
 * order_info	        OrderInfo	Optional. Order info provided by the user
 */
@Data
@JsonInclude(NON_NULL)
public class PreCheckoutQuery {
    private String id;

    private User from;

    private String currency;

    @JsonProperty("total_amount")
    private Integer totalAmount;

    @JsonProperty("invoice_payload")
    private String invoicePayload;

    @JsonProperty("shipping_option_id")
    private String shippingOptionId;

    @JsonProperty("order_info")
    private OrderInfo orderInfo;
}
