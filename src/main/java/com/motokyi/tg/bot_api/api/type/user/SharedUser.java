package com.motokyi.tg.bot_api.api.type.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import lombok.Data;

import java.util.List;

/**
 * This object contains information about
 * a user that was shared with the bot using a KeyboardButtonRequestUsers button.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#shareduser">SharedUser</a>
 */
@Data
public class SharedUser {
    @JsonProperty(ApiProperties.USER_ID)
    private Long userId;

    @JsonProperty(ApiProperties.FIRST_NAME)
    private Long firstName;

    @JsonProperty(ApiProperties.LAST_NAME)
    private Long lastName;

    private String username;

    private List<PhotoSize> photo;

}