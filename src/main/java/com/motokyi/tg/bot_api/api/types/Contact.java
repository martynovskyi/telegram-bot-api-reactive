package com.motokyi.tg.bot_api.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a phone contact.
 * See <a href="Contact">https://core.telegram.org/bots/api#contact</a>
 * <p>
 * Field	    Type	Description
 * phone_number	String	Contact's phone number
 * first_name	String	Contact's first name
 * last_name	String	Optional. Contact's last name
 * user_id	    Integer	Optional. Contact's user identifier in Telegram
 */
@Data
public class Contact {

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("user_id")
    private Long userId;

}
