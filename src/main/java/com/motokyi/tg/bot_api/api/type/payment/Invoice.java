package com.motokyi.tg.bot_api.api.type.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object contains basic information about an invoice.
 * See <a href="Invoice">https://core.telegram.org/bots/api#invoice</a>
 * <p>
 *
 * @version Bot API 6.9
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
