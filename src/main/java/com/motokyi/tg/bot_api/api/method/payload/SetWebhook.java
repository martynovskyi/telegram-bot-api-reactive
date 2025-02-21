package com.motokyi.tg.bot_api.api.method.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.input.InputFile;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * Use this method to specify a URL and receive incoming updates via an outgoing webhook.
 * Whenever there is an update for the bot, we will send an HTTPS POST request to the specified URL,
 * containing a JSON-serialized Update. In case of an unsuccessful request, we will give up after a
 * reasonable amount of attempts. Returns True on success.
 * <p>
 * If you'd like to make sure that the webhook was set by you, you can specify secret data in the
 * parameter secret_token. If specified, the request will contain a header
 * “X-Telegram-Bot-Api-Secret-Token” with the secret token as content.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#setwebhook">setWebhook</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetWebhook {
    private String url;

    private InputFile certificate;

    @JsonProperty(ApiProperties.IP_ADDRESS)
    private String ipAddress;

    @JsonProperty(ApiProperties.MAX_CONNECTIONS)
    private Integer maxConnections;

    @JsonProperty(ApiProperties.ALLOWED_UPDATES)
    private List<String> allowedUpdates;

    @JsonProperty(ApiProperties.DROP_PENDING_UPDATES)
    private Boolean dropPendingUpdates;

    @JsonProperty(ApiProperties.SECRET_TOKEN)
    private String secretToken;

    public SetWebhook(@NotNull String url) {
        this.url = url;
    }
}
