package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Use this method to send answers to callback queries sent from inline keyboards. The answer will
 * be displayed to the user as a notification at the top of the chat screen or as an alert. On
 * success, True is returned.
 *
 * <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work,
 * you must first create a game for your bot via @BotFather and accept the terms. Otherwise, you may
 * use links like t.me/your_bot?start=XXXX that open your bot with a parameter.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#answercallbackquery">answerCallbackQuery</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerCallbackQuery {
    @JsonProperty(ApiProperties.CALLBACK_QUERY_ID)
    private String callbackQueryId;

    private String text;

    @JsonProperty(ApiProperties.SHOW_ALERT)
    private Boolean showAlert;

    private String url;

    @JsonProperty(ApiProperties.CACHE_TIME)
    private Integer cacheTime;

    public AnswerCallbackQuery(String callbackQueryId) {
        this.callbackQueryId = callbackQueryId;
    }
}
