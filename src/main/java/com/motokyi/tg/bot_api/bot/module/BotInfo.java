package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.bot.BotDescription;
import com.motokyi.tg.bot_api.api.type.bot.BotName;
import com.motokyi.tg.bot_api.api.type.bot.BotShortDescription;
import com.motokyi.tg.bot_api.api.type.user.User;
import reactor.core.publisher.Mono;

/**
 * Interface defines bot operations related to bot information
 */
public interface BotInfo {
    Mono<Response<User>> getMe();

    Mono<Response<BotName>> getMyName();

    Mono<Response<Boolean>> setMyName(String name);

    Mono<Response<BotName>> getMyName(String languageCode);

    Mono<Response<Boolean>> setMyName(String name, String languageCode);

    Mono<Response<BotDescription>> getMyDescription();

    Mono<Response<Boolean>> setMyDescription(String description);

    Mono<Response<BotDescription>> getMyDescription(String languageCode);

    Mono<Response<Boolean>> setMyDescription(String description, String languageCode);

    Mono<Response<BotShortDescription>> getMyShortDescription();

    Mono<Response<Boolean>> setMyShortDescription(String shortDescription);

    Mono<Response<BotShortDescription>> getMyShortDescription(String languageCode);

    Mono<Response<Boolean>> setMyShortDescription(String shortDescription, String languageCode);

}
