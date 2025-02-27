package com.motokyi.tg.bot_api.api.method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.client.BotApiClient;
import reactor.core.publisher.Mono;

/***
 * Enhanced {@link com.motokyi.tg.bot_api.api.method.payload.AnswerCallbackQuery answerCallbackQuery} method with the
 * ability to self-execution and chain setter
 */
public class AnswerCallbackQuery
        extends com.motokyi.tg.bot_api.api.method.payload.AnswerCallbackQuery
        implements BotMethod<Response<Boolean>> {

    @JsonIgnore private final BotApiClient client;

    public AnswerCallbackQuery(String callbackQueryId, BotApiClient client) {
        super(callbackQueryId);
        this.client = client;
    }

    @Override
    public Mono<Response<Boolean>> send() {
        return client.send(this);
    }

    public AnswerCallbackQuery text(String text) {
        super.setText(text);
        return this;
    }

    public AnswerCallbackQuery showAlert(Boolean showAlert) {
        super.setShowAlert(showAlert);
        return this;
    }

    public AnswerCallbackQuery url(String url) {
        super.setUrl(url);
        return this;
    }

    public AnswerCallbackQuery cacheTime(Integer cacheTime) {
        super.setCacheTime(cacheTime);
        return this;
    }
}
