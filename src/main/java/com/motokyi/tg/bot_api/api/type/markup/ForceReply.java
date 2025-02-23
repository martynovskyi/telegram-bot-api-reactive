package com.motokyi.tg.bot_api.api.type.markup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the
 * user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be
 * extremely useful if you want to create user-friendly step-by-step interfaces without having to
 * sacrifice privacy mode.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#forcereply">ForceReply</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForceReply extends KeyboardMarkup {

    @JsonProperty("force_reply")
    private Boolean forceReply;

    @JsonProperty("input_field_placeholder")
    private String inputFieldPlaceholder;

    private Boolean selective;
}
