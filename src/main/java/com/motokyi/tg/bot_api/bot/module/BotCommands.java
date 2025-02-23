package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.method.DeleteMyCommands;
import com.motokyi.tg.bot_api.api.method.GetMyCommands;
import com.motokyi.tg.bot_api.api.method.SetMyCommands;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/** Interface defines bot operations related to Bot Commands */
public interface BotCommands {
    Mono<Response<Boolean>> send(
            @NotNull com.motokyi.tg.bot_api.api.method.payload.SetMyCommands commandsPayload);

    SetMyCommands setMyCommands();

    Mono<Response<List<BotCommand>>> send(
            @NotNull com.motokyi.tg.bot_api.api.method.payload.GetMyCommands getCommandsPayload);

    GetMyCommands getMyCommands();

    Mono<Response<List<BotCommand>>> getMyCommands(BotCommandScope scope);

    Mono<Response<List<BotCommand>>> getMyCommands(BotCommandScope scope, String languageCode);

    Mono<Response<Boolean>> send(
            @NotNull com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands deleteCommandsPayload);

    DeleteMyCommands deleteMyCommands();

    Mono<Response<Boolean>> deleteMyCommands(BotCommandScope scope);

    Mono<Response<Boolean>> deleteMyCommands(BotCommandScope scope, String languageCode);
}
