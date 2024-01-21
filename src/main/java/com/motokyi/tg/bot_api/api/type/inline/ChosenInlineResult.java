package com.motokyi.tg.bot_api.api.type.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.Location;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat partner.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#choseninlineresult">ChosenInlineResult</a>
 */
@Data
public class ChosenInlineResult {

    @JsonProperty("result_id")
    private String resultId;

    private User from;

    private Location location;

    @JsonProperty(ApiProperties.INLINE_MESSAGE_ID)
    private String inlineMessageId;

    private String query;


}
