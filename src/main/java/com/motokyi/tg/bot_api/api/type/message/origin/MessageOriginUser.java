package com.motokyi.tg.bot_api.api.type.message.origin;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The message was originally sent by a known user.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#messageoriginuser">MessageOriginUser</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageOriginUser extends MessageOrigin {

    @JsonProperty(ApiProperties.SENDER_USER)
    private User senderUser;

}