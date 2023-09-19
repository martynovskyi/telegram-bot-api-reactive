package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to remove webhook integration if you decide to switch back to getUpdates. Returns True on success.
 *
 * See <a href="DeleteWebhook">https://core.telegram.org/bots/api#deletewebhook</a>
 *
 * @version Bot API 6.8
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteWebhook {
    public static final String DROP_PENDING_UPDATES_PROP = "drop_pending_updates";

    @JsonProperty(DROP_PENDING_UPDATES_PROP)
    private Boolean dropPendingUpdates;
}
