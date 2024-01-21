package com.motokyi.tg.bot_api.api.type.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.LoginUrl;
import com.motokyi.tg.bot_api.api.type.game.CallbackGame;
import com.motokyi.tg.bot_api.api.type.web_app.WebAppInfo;
import lombok.Data;

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardbutton">InlineKeyboardButton</a>
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineKeyboardButton {
    private String text;

    private String url;

    @JsonProperty("callback_data")
    private String callbackData;

    @JsonProperty(ApiProperties.WEB_APP)
    private WebAppInfo webApp;

    @JsonProperty("login_url")
    private LoginUrl loginUrl;

    @JsonProperty("switch_inline_query")
    private String switchInlineQuery;

    @JsonProperty("switch_inline_query_current_chat")
    private String switchInlineQueryCurrentChat;

    @JsonProperty("switch_inline_query_chosen_chat")
    private SwitchInlineQueryChosenChat switchInlineQueryChosenChat;

    @JsonProperty("callback_game")
    private CallbackGame callbackGame;

    private Boolean pay;
}
