package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.method.payload.*;
import com.motokyi.tg.bot_api.api.type.*;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BotApiClient {

    Mono<Response<User>> getMe();

    Mono<Response<List<Update>>> getUpdates();

    Mono<Response<List<Update>>> getUpdates(GetUpdates getUpdates);

    Mono<Response<Chat>> getChat(String chatTag);

    Mono<Response<Message>> send(SendMessage message);

    Mono<Response<Message>> send(SendPhoto document);

    Mono<Response<Message>> send(SendDocument document);

    Mono<Response<Message>> send(SendAnimation document);

    Mono<Response<Boolean>> send(SetMyCommands commands);

    Mono<Response<Boolean>> send(DeleteMyCommands commands);

    Mono<Response<List<BotCommand>>> send(GetMyCommands getMyCommands);

    Mono<Response<Message>> forwardMessage(ForwardMessage forwardMessage);

    Mono<Response<Message>> editMessageReplyMarkup(EditMessageReplyMarkup editMessageReplyMarkup);

    Mono<Response<Boolean>> deleteMessage(Long chatId, Long messageId);
}
