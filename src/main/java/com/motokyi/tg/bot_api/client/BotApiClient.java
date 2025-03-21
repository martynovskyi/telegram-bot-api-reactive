package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.method.payload.*;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.bot.BotDescription;
import com.motokyi.tg.bot_api.api.type.bot.BotName;
import com.motokyi.tg.bot_api.api.type.bot.BotShortDescription;
import com.motokyi.tg.bot_api.api.type.chat.ChatFullInfo;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMember;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.api.type.update.WebhookInfo;
import com.motokyi.tg.bot_api.api.type.user.User;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import reactor.core.publisher.Mono;

public interface BotApiClient {

    Mono<Response<User>> getMe();

    Mono<Response<BotName>> getMyName(@Nullable String languageCode);

    Mono<Response<Boolean>> setMyName(@Nullable String name, @Nullable String languageCode);

    Mono<Response<BotDescription>> getMyDescription(@Nullable String languageCode);

    Mono<Response<Boolean>> setMyDescription(
            @Nullable String description, @Nullable String languageCode);

    Mono<Response<BotShortDescription>> getMyShortDescription(@Nullable String languageCode);

    Mono<Response<Boolean>> setMyShortDescription(String shortDescription, String languageCode);

    Mono<Response<List<Update>>> getUpdates();

    Mono<Response<List<Update>>> getUpdates(@NotNull GetUpdates getUpdates);

    Mono<Response<ChatFullInfo>> getChat(@NotNull String chatTag);

    Mono<Response<Boolean>> leaveChat(@NotNull String chatId);

    Mono<Response<Integer>> getChatMemberCount(@NotNull String chatId);

    <T extends ChatMember> Mono<Response<T>> getChatMember(
            @NotNull String chatId, @NotNull Long userId);

    Mono<Response<Message>> send(@NotNull SendMessage message);

    Mono<Response<Message>> send(@NotNull SendPhoto photo);

    Mono<Response<Message>> send(@NotNull SendDocument document);

    Mono<Response<Message>> send(@NotNull SendAnimation document);

    Mono<Response<Boolean>> send(@NotNull SetMyCommands commands);

    Mono<Response<Boolean>> send(@NotNull DeleteMyCommands commands);

    Mono<Response<List<BotCommand>>> send(@NotNull GetMyCommands getMyCommands);

    Mono<Response<Message>> forwardMessage(@NotNull ForwardMessage forwardMessage);

    Mono<Response<Boolean>> deleteMessage(@NotNull Long chatId, @NotNull Long messageId);

    Mono<Response<Message>> send(@NotNull EditMessageReplyMarkup editMessageReplyMarkup);

    Mono<Response<Message>> send(@NotNull EditMessageText editMessageText);

    /**
     * @see <a href="https://core.telegram.org/bots/api#answercallbackquery">answerCallbackQuery</a>
     */
    Mono<Response<Boolean>> send(@NotNull AnswerCallbackQuery answerCallbackQuery);

    /**
     * @see <a href="https://core.telegram.org/bots/api#setmessagereaction">setMessageReaction</a>
     */
    Mono<Response<Boolean>> send(@NotNull SetMessageReaction setMessageReaction);

    Mono<Response<Boolean>> send(@NotNull SetWebhook setWebhook);

    Mono<Response<Boolean>> send(@NotNull DeleteWebhook deleteWebhook);

    Mono<Response<WebhookInfo>> getWebhookInfo();
}
