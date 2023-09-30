package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a phone contact.
 * See <a href="Contact">https://core.telegram.org/bots/api#contact</a>
 * <p>
 *
 * @version Bot API 6.9
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
