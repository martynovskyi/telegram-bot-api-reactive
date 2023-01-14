package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeleteWebhook {
    @JsonProperty("drop_pending_updates")
    private Long dropPendingUpdates;
}
