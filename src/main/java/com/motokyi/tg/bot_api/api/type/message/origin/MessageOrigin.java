package com.motokyi.tg.bot_api.api.type.message.origin;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.MessageOriginTypes;
import lombok.Data;

/**
 * This object describes the origin of a message. It can be one of
 * - MessageOriginUser
 * - MessageOriginHiddenUser
 * - MessageOriginChat
 * - MessageOriginChannel
 * <p>
 * See <a href="MessageOrigin">https://core.telegram.org/bots/api#messageorigin</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MessageOriginUser.class, name = MessageOriginTypes.USER),
        @JsonSubTypes.Type(value = MessageOriginHiddenUser.class, name = MessageOriginTypes.HIDDEN_USER),
        @JsonSubTypes.Type(value = MessageOriginChat.class, name = MessageOriginTypes.CHAT),
        @JsonSubTypes.Type(value = MessageOriginChannel.class, name = MessageOriginTypes.CHANNEL),
})
public abstract class MessageOrigin {

    private String type;

    private Long date;
}