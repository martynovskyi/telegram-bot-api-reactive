package com.motokyi.tg.botapi.api.types.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if
 * the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create
 * user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 * See <a href="ForceReply">https://core.telegram.org/bots/api#forcereply</a>
 * <p>
 * Field        Type	  Description
 * force_reply	True	  Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
 * selective	Boolean   Optional. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForceReply extends KeyboardMarkup {
    @JsonProperty("force_reply")
    private Boolean forceReply;

    private Boolean selective;
}
