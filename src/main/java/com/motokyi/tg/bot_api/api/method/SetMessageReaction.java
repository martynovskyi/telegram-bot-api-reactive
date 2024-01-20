package com.motokyi.tg.bot_api.api.method;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionType;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

import java.util.List;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.SetMessageReaction SetMessageReaction} method with the ability
 * to self-execution and chain setter
 */
public class SetMessageReaction
        extends com.motokyi.tg.bot_api.api.method.payload.SetMessageReaction
        implements BotMethod<Response<Boolean>> {

    @JsonIgnore
    private final BotApiClient client;

    public SetMessageReaction(BotApiClient client, String chatId, Long messageId) {
        super(chatId, messageId);
        this.client = client;
    }

    public SetMessageReaction(BotApiClient client, Long chatId, Long messageId) {
        super(String.valueOf(chatId), messageId);
        this.client = client;
    }

    @Override
    public Mono<Response<Boolean>> send() {
        return client.send(this);
    }

    public SetMessageReaction reaction(List<ReactionType> reaction) {
        super.setReaction(reaction);
        return this;
    }

    public SetMessageReaction isBig(Boolean isBig) {
        super.setIsBig(isBig);
        return this;
    }

}
