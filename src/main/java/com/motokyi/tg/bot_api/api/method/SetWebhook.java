package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.input.InputFile;
import com.motokyi.tg.bot_api.client.BotApiClient;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

import java.util.List;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SetWebhook SetWebhook} method with the ability to
 * self-execution and chain setter
 */
public class SetWebhook
        extends com.motokyi.tg.bot_api.api.method.payload.SetWebhook
        implements BotMethod<Response<Boolean>> {
    @JsonIgnore
    private final BotApiClient client;

    public SetWebhook(@NotNull BotApiClient client, @NotNull String url) {
        super(url);
        this.client = client;
    }

    @Override
    public Mono<Response<Boolean>> send() {
        return this.client.send(this);
    }

    public SetWebhook url(String url) {
        super.setUrl(url);
        return this;
    }

    public SetWebhook certificate(InputFile certificate) {
        super.setCertificate(certificate);
        return this;
    }

    public SetWebhook ipAddress(String ipAddress) {
        super.setIpAddress(ipAddress);
        return this;
    }

    public SetWebhook maxConnections(Integer maxConnections) {
        super.setMaxConnections(maxConnections);
        return this;
    }

    public SetWebhook allowedUpdates(List<String> allowedUpdates) {
        super.setAllowedUpdates(allowedUpdates);
        return this;
    }

    public SetWebhook dropPendingUpdates(Boolean dropPendingUpdates) {
        super.setDropPendingUpdates(dropPendingUpdates);
        return this;
    }

    public SetWebhook secretToken(String secretToken) {
        super.setSecretToken(secretToken);
        return this;
    }
}
