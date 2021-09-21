package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.api.methods.DeleteMyCommands;
import com.motokyi.tg.botapi.api.methods.EditMessageReplyMarkup;
import com.motokyi.tg.botapi.api.methods.ForwardMessage;
import com.motokyi.tg.botapi.api.methods.GetMyCommands;
import com.motokyi.tg.botapi.api.methods.GetUpdates;
import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendDocument;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendPhoto;
import com.motokyi.tg.botapi.api.methods.SetMyCommands;
import com.motokyi.tg.botapi.api.types.Chat;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.api.types.User;
import com.motokyi.tg.botapi.api.types.command.BotCommand;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BotWebClient {

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
