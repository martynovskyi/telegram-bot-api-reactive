package com.motokyi.tg.bot_api.api.type.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import java.util.List;
import lombok.Data;

/**
 * This object contains information about the users whose identifiers were shared with the bot using
 * a KeyboardButtonRequestUsers button.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#usersshared">UsersShared</a>
 */
@Data
public class UsersShared {

    @JsonProperty(ApiProperties.REQUEST_ID)
    private Long requestId;

    private List<SharedUser> users;
}
