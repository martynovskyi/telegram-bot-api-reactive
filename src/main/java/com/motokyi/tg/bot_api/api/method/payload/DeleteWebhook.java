package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to remove webhook integration if you decide to switch back to getUpdates. Returns True on success.
 * <p>
 * See <a href="DeleteWebhook">https://core.telegram.org/bots/api#deletewebhook</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteWebhook {

    @JsonProperty(ApiProperties.DROP_PENDING_UPDATES_PROP)
    private Boolean dropPendingUpdates;
}
