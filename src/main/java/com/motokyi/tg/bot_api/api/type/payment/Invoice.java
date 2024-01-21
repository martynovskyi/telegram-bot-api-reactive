package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object contains basic information about an invoice.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#invoice">Invoice</a>
 */
@Data
public class Invoice {

    private String title;

    private String description;

    @JsonProperty("start_parameter")
    private String startParameter;

    private String currency;

    @JsonProperty(ApiProperties.TOTAL_AMOUNT)
    private Integer totalAmount;
}
