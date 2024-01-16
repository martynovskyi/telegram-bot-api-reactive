package com.motokyi.tg.bot_api.api.type.message.origin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The message was originally sent by an unknown user.
 * <p>
 * See <a href="MessageOriginHiddenUser">https://core.telegram.org/bots/api#messageoriginhiddenuser</a>
 * <p>
 *
 * @version Bot API 7.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageOriginHiddenUser extends MessageOrigin {

    @JsonProperty(ApiProperties.SENDER_USER_NAME)
    private String senderUserName;
}
