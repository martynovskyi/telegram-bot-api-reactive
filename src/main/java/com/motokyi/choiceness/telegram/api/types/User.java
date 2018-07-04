package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * This object represents a Telegram user or bot.
 * See <a href="User">https://core.telegram.org/bots/api#user</a>
 * <p>
 * Field         Type	 Description
 * id            Integer Unique identifier for this user or bot
 * is_bot        Boolean True, if this user is a bot
 * first_name    String	 User‘s or bot’s first name
 * last_name	 String	 Optional. User‘s or bot’s last name
 * username	     String	 Optional. User‘s or bot’s username
 * language_code String	 Optional. IETF language tag of the user's language
 */
@Data
public class User {

    private Long id;

    @JsonProperty("is_bot")
    private Boolean bot;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("language_code")
    private String languageCode;
}
