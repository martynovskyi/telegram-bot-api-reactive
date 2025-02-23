package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.method.ForwardMessage;
import com.motokyi.tg.bot_api.api.method.SendMessage;
import com.motokyi.tg.bot_api.api.method.SetMessageReaction;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.message.Message;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/** Interface defines bot operations related to Message */
public interface BotMessage {
    SendMessage sendMessage(@NotNull Long chatId);

    SendMessage sendMessage(@NotNull String chatTag);

    SendMessage sendMessage(@NotNull Chat chat);

    Mono<Response<Message>> sendMessage(@NotNull Long chatId, @NotNull String text);

    Mono<Response<Message>> sendMessage(@NotNull Chat chat, @NotNull String text);

    ForwardMessage forwardMessage(@NotNull String chatId, @NotNull Message message);

    ForwardMessage forwardMessage(
            @NotNull String chatId, @NotNull Long fromChatId, @NotNull Long messageId);

    Mono<Response<Boolean>> deleteMessage(@NotNull Long chatId, @NotNull Long messageId);

    SetMessageReaction setMessageReaction(@NotNull String chatId, @NotNull Long messageId);

    SetMessageReaction setMessageReaction(@NotNull Long chatId, @NotNull Long messageId);

    SetMessageReaction setMessageReaction(@NotNull Chat chat, @NotNull Message message);

    Mono<Response<Boolean>> dropMessageReaction(@NotNull String chatId, @NotNull Long messageId);
}
