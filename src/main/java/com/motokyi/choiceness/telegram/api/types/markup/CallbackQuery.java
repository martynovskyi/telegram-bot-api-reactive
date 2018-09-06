package com.motokyi.choiceness.telegram.api.types.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.choiceness.telegram.api.types.Message;
import com.motokyi.choiceness.telegram.api.types.User;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard. If the button that
 * originated the query was attached to a message sent by the bot, the field message will be present. If the button was
 * attached to a message sent via the bot (in inline mode), the field inline_message_id will be present. Exactly one of
 * the fields data or game_short_name will be present.
 * See <a href="CallbackQuery">https://core.telegram.org/bots/api#callbackquery</a>
 * <p>
 * Field                Type      Description
 * id	                String	  Unique identifier for this query
 * from	                User	  Sender
 * message	            Message	  Optional. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
 * inline_message_id	String	  Optional. Identifier of the message sent via the bot in inline mode, that originated the query.
 * chat_instance	    String	  Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
 * data	                String	  Optional. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
 * game_short_name	    String	  Optional. Short name of a Game to be returned, serves as the unique identifier for the game
 * <p>
 * NOTE: After the user presses a callback button, Telegram clients will display a progress bar until you call
 * answerCallbackQuery. It is, therefore, necessary to react by calling answerCallbackQuery even if no notification to
 * the user is needed (e.g., without specifying any of the optional parameters).
 */
@Data
@JsonInclude(NON_NULL)
public class CallbackQuery {

    private String id;

    private User from;

    private Message message;

    @JsonProperty("inline_message_id")
    private String inlineMessageId;

    @JsonProperty("chat_instance")
    private String chatInstance;

    private String data;

    @JsonProperty("game_short_name")
    private String gameShortName;
}
