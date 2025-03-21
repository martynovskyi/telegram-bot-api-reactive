package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.chat.ChatFullInfo;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMember;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

public interface Chat {
    Mono<Response<ChatFullInfo>> getChat(@NotNull Long chatId);

    Mono<Response<ChatFullInfo>> getChat(@NotNull String chatTag);

    Mono<Response<Boolean>> leaveChat(@NotNull Long chatId);

    Mono<Response<Boolean>> leaveChat(@NotNull String chatTag);

    Mono<Response<Integer>> getChatMemberCount(@NotNull Long chatId);

    Mono<Response<Integer>> getChatMemberCount(@NotNull String chatTag);

    <T extends ChatMember> Mono<Response<T>> getChatMember(
            @NotNull Long chatId, @NotNull Long userId);

    <T extends ChatMember> Mono<Response<T>> getChatMember(
            @NotNull String chatTag, @NotNull Long userId);
}
