package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to remove webhook integration if you decide to switch back to getUpdates. Returns True on success.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#deletewebhook">deleteWebhook</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteWebhook {

    @JsonProperty(ApiProperties.DROP_PENDING_UPDATES)
    private Boolean dropPendingUpdates;
}
