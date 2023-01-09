package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.*;
import com.motokyi.tg.bot_api.api.types.*;
import com.motokyi.tg.bot_api.api.types.command.BotCommand;
import com.motokyi.tg.bot_api.api.types.command.BotCommandScope;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Convenient facade for all Bot API
 */
public interface Bot {
    Mono<Response<User>> getMe();

    Mono<Response<List<Update>>> getAllUpdates();

    GetUpdates getUpdates();

    Mono<Response<Chat>> getChat(Long chatId);

    Mono<Response<Chat>> getChat(String chatTag);

    SendMessage sendMessage(Long chatId);

    SendMessage sendMessage(String chatTag);

    Mono<Response<Message>> sendMessage(Long chatId, String text);

    SendDocument sendDocument(Long chatId);

    SendDocument sendDocument(String chatTag);

    SendPhoto sendPhoto(Long chatId);

    SendPhoto sendPhoto(String chatTag);

    SendAnimation sendAnimation(Long chatId);

    SendAnimation sendAnimation(String chatTag);

    ForwardMessage forwardMessage(String chatId, Message message);

    ForwardMessage forwardMessage(String chatId, Long fromChatId, Long messageId);

    EditMessageReplyMarkup editMessageReplyMarkup(Long chatId, Long messageId);

    Mono<Response<Boolean>> deleteMessage(Long chatId, Long messageId);

    SetMyCommands setMyCommands();

    Mono<Response<Boolean>> deleteMyCommands(BotCommandScope scope);

    Mono<Response<List<BotCommand>>> getMyCommands(BotCommandScope scope);
}
