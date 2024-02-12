package com.motokyi.tg.bot_api.api.type.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;


/**
 * This object represents an incoming callback query from a callback button in an inline keyboard. If the button that
 * originated the query was attached to a message sent by the bot, the field message will be present. If the button was
 * attached to a message sent via the bot (in inline mode), the field inline_message_id will be present. Exactly one of
 * the fields data or game_short_name will be present.
 * <p>
 * NOTE: After the user presses a callback button, Telegram clients will display a progress bar until you call
 * answerCallbackQuery. It is, therefore, necessary to react by calling answerCallbackQuery even if no notification to
 * the user is needed (e.g., without specifying any of the optional parameters).
 *
 * @version Bot API 6.9
 * @see <a href="https://core.telegram.org/bots/api#callbackquery">CallbackQuery</a>
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallbackQuery {

    private String id;

    private User from;

    //todo: MaybeInaccessibleMessage
    private Message message;

    @JsonProperty(ApiProperties.INLINE_MESSAGE_ID)
    private String inlineMessageId;

    @JsonProperty("chat_instance")
    private String chatInstance;

    private String data;

    @JsonProperty("game_short_name")
    private String gameShortName;
}
