package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.api.methods.ForwardMessage;
import com.motokyi.tg.botapi.api.methods.GetUpdates;
import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendDocument;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendPhoto;
import com.motokyi.tg.botapi.api.types.Chat;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.TGResponce;
import com.motokyi.tg.botapi.api.types.Update;
import com.motokyi.tg.botapi.api.types.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TGWebClient {

    Mono<TGResponce<User>> getMe();

    Mono<TGResponce<List<Update>>> getUpdates();

    Mono<TGResponce<List<Update>>> getUpdates(GetUpdates getUpdates);

    Mono<TGResponce<Chat>> getChat(String chatTag);

    Mono<TGResponce<Message>> send(SendMessage message);

    Mono<TGResponce<Message>> send(SendPhoto document);

    Mono<TGResponce<Message>> send(SendDocument document);

    Mono<TGResponce<Message>> send(SendAnimation document);

    Mono<TGResponce<Message>> forwardMessage(ForwardMessage forwardMessage);
}
