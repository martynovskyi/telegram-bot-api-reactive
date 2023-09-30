package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.user.User;
import reactor.core.publisher.Mono;

/**
 * Interface defines bot operations related to bot information
 */
public interface BotInfo {
    Mono<Response<User>> getMe();
    // TODO: 9/22/2023
//    Mono<Response<String>> getMyName();

//    Mono<Response<Boolean>> setMyName();

//    Mono<Response<String>> getMyDescription();

//    Mono<Response<Boolean>> setMyDescription();

//    Mono<Response<String>> getMyShortDescription();

//    Mono<Response<Boolean>> setMyShortDescription();
}
