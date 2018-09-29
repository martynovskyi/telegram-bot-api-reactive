package com.motokyi.choiceness.telegram.webclient;

import com.motokyi.choiceness.telegram.api.methods.*;
import com.motokyi.choiceness.telegram.api.types.*;
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
}
