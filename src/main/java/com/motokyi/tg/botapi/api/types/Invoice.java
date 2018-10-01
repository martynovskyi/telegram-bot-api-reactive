package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object contains basic information about an invoice.
 * See <a href="Invoice">https://core.telegram.org/bots/api#invoice</a>
 * <p>
 * Field	        Type    Description
 * title	        String	Product name
 * description	    String	Product description
 * start_parameter	String	Unique bot deep-linking parameter that can be used to generate this invoice
 * currency	        String	Three-letter ISO 4217 currency code
 * total_amount	    Integer	Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 */
@Data
public class Invoice {

    private String title;

    private String description;

    @JsonProperty("start_parameter")
    private String startParameter;

    private String currency;

    @JsonProperty("total_amount")
    private Integer totalAmount;
}
