package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.config.properties.TelegramBotProperties;
import com.motokyi.tg.bot_api.utils.ClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
public class BotApiClientBuilder {
    public static BotApiClient build(TelegramBotProperties botProperties) {

        return new BotClient(WebClient.builder()
                .baseUrl(ClientUtils.createHostUrl(botProperties))
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .filter(ClientUtils.logRequest(log))
                .filter(ClientUtils.logResponse(log))
                .build());
    }
}
