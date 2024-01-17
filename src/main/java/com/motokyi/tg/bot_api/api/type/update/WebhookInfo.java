package com.motokyi.tg.bot_api.api.type.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Describes the current status of a webhook.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#webhookinfo">WebhookInfo</a>
 */
@Data
public class WebhookInfo {

    private String url;

    @JsonProperty("has_custom_certificate")
    private Boolean hasCustomCertificate;

    @JsonProperty("pending_update_count")
    private Integer pendingUpdateCount;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("last_error_date")
    private Long lastErrorDate;

    @JsonProperty("last_error_message")
    private String lastErrorMessage;

    @JsonProperty("last_synchronization_error_date")
    private Integer lastSynchronizationErrorDate;

    @JsonProperty("max_connections")
    private Integer maxConnections;

    @JsonProperty("allowed_updates")
    private List<String> allowedUpdates;
}
