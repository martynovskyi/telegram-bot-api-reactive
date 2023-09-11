package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.utils.ClientUtils;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;


@Slf4j
@NoArgsConstructor
public class BotApiClientBuilder {
    private BotConfigProperty botProperties;
    private WebClient.Builder builder;


    public BotApiClientBuilder withBotProperties(BotConfigProperty botProperties) {
        this.botProperties = botProperties;
        return this;
    }

    public BotApiClientBuilder withWebClientBuilder(WebClient.Builder builder) {
        this.builder = builder;
        return this;
    }

    public BotApiClient build() {
        Objects.requireNonNull(botProperties, "Incorrect builder args. Missing bot properties.");

        if (Objects.isNull(builder)) {
            builder = WebClient.builder();
        }
        builder.baseUrl(ClientUtils.createBotUrl(botProperties))
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .filter(ClientUtils.logRequest(log))
                .filter(ClientUtils.logResponse(log));

        return new BotClient(builder.build());
    }
}
