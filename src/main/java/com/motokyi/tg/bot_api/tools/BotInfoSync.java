package com.motokyi.tg.bot_api.tools;

import static java.util.Objects.isNull;

import com.motokyi.tg.bot_api.api.method.payload.SetMyCommands;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.client.BotApiClient;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class BotInfoSync {
    private final BotApiClient client;
    private final List<SetMyCommands> botCommands = new ArrayList<>();
    private final List<Pair<String, String>> shortDescriptions = new ArrayList<>();
    private final List<Pair<String, String>> descriptions = new ArrayList<>();
    private final List<Pair<String, String>> names = new ArrayList<>();

    public BotInfoSync command(SetMyCommands command) {
        if (isNull(command)) {
            log.warn("Null SetMyCommands value is ignored");
        } else {
            botCommands.add(command);
        }
        return this;
    }

    public BotInfoSync shortDescription(String shortDescription, String languageCode) {
        shortDescriptions.add(Pair.of(shortDescription, languageCode));
        return this;
    }

    public BotInfoSync description(String description, String languageCode) {
        descriptions.add(Pair.of(description, languageCode));
        return this;
    }

    public BotInfoSync name(String name, String languageCode) {
        names.add(Pair.of(name, languageCode));
        return this;
    }

    public Mono<Void> sync() {
        return sync(Duration.ZERO);
    }

    public Mono<Void> sync(Duration delay) {
        return Flux.fromStream(botCommands.stream())
                .delayElements(delay)
                .flatMap(
                        sbc -> {
                            var commands = sbc.getCommands().stream().map(BotCommand::getCommand).toList();
                            log.debug(
                                    "Prepare to sync commands {}, scope {}, lang {}",
                                    commands,
                                    sbc.getScope(),
                                    sbc.getLanguageCode());
                            return client
                                    .send(sbc)
                                    .doOnSuccess(
                                            rs ->
                                                    log.info(
                                                            "Sync commands {} result ok={} result={} description:{}",
                                                            commands,
                                                            rs.isOk(),
                                                            rs.getResult(),
                                                            rs.getDescription()));
                        })
                .thenMany(Flux.fromStream(descriptions.stream()))
                .delayElements(delay)
                .flatMap(
                        sd -> {
                            log.debug("Prepare to sync bot description {}, lang {}", sd.getKey(), sd.getValue());
                            return client
                                    .setMyDescription(sd.getKey(), sd.getValue())
                                    .doOnSuccess(
                                            rs ->
                                                    log.info(
                                                            "Sync description for lang={} result ok={} result={} description:{}",
                                                            sd.getValue(),
                                                            rs.isOk(),
                                                            rs.getResult(),
                                                            rs.getDescription()));
                        })
                .thenMany(Flux.fromStream(shortDescriptions.stream()))
                .delayElements(delay)
                .flatMap(
                        sd -> {
                            log.debug(
                                    "Prepare to sync bot short description {}, lang {}", sd.getKey(), sd.getValue());
                            return client
                                    .setMyShortDescription(sd.getKey(), sd.getValue())
                                    .doOnSuccess(
                                            rs ->
                                                    log.info(
                                                            "Sync short description for lang={} result ok={} result={} description:{}",
                                                            sd.getValue(),
                                                            rs.isOk(),
                                                            rs.getResult(),
                                                            rs.getDescription()));
                        })
                .thenMany(Flux.fromStream(names.stream()))
                .delayElements(delay)
                .flatMap(
                        sd -> {
                            log.debug("Prepare to sync bot name {}, lang {}", sd.getKey(), sd.getValue());
                            return client
                                    .setMyName(sd.getKey(), sd.getValue())
                                    .doOnSuccess(
                                            rs ->
                                                    log.info(
                                                            "Sync name for lang={} result ok={} result={} description:{}",
                                                            sd.getValue(),
                                                            rs.isOk(),
                                                            rs.getResult(),
                                                            rs.getDescription()));
                        })
                .then();
    }
}
