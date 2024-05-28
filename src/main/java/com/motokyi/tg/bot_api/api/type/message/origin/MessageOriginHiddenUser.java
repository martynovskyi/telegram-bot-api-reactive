package com.motokyi.tg.bot_api.api.type.message.origin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The message was originally sent by an unknown user.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#messageoriginhiddenuser">MessageOriginHiddenUser</a>
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageOriginHiddenUser extends MessageOrigin {

    @JsonProperty(ApiProperties.SENDER_USER_NAME)
    private String senderUserName;
}
