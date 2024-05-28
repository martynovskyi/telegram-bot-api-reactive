package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a phone contact.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#contact">Contact</a>
 */
@Data
public class Contact {

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty(ApiProperties.FIRST_NAME)
    private String firstName;

    @JsonProperty(ApiProperties.LAST_NAME)
    private String lastName;

    @JsonProperty(ApiProperties.USER_ID)
    private Long userId;

    private String vcard;

}
