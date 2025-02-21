package com.motokyi.tg.bot_api.api.type.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.Location;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This object represents an incoming inline query. When the user sends an empty query,
 * your bot could return some default or trending results.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#inlinequery">InlineQuery</a>
 */
@Data
@JsonInclude(NON_NULL)
public class InlineQuery {

    private String id;

    private User from;

    private String query;

    private String offset;

    @JsonProperty("chat_type")
    private String chatType;

    private Location location;
}
