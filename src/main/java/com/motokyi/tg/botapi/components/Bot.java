package com.motokyi.tg.botapi.components;

import com.motokyi.tg.botapi.api.methods.EditMessageReplyMarkup;
import com.motokyi.tg.botapi.api.methods.ForwardMessage;
import com.motokyi.tg.botapi.api.methods.GetUpdates;
import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendDocument;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendPhoto;
import com.motokyi.tg.botapi.api.types.Chat;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.api.types.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface Bot {
    Mono<Response<User>> getMe();

    Mono<Response<List<Update>>> getAllUpdates();

    GetUpdates getUpdates();

    Mono<Response<Chat>> getChat(Long chatId);

    Mono<Response<Chat>> getChat(String chatTag);

    SendMessage sendMessage(Long chatId);

    SendMessage sendMessage(String chatTag);

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
}
