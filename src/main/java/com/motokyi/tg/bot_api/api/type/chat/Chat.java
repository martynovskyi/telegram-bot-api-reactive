package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;


/**
 * This object represents a chat.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#chat">Chat</a>
 */
@Data
public class Chat {

    private Long id;

    private String type;

    private String title;

    @JsonProperty(ApiProperties.USERNAME)
    private String userName;

    @JsonProperty(ApiProperties.FIRST_NAME)
    private String firstName;

    @JsonProperty(ApiProperties.LAST_NAME)
    private String lastName;

    @JsonProperty(ApiProperties.IS_FORUM)
    private Boolean isForum;
}
