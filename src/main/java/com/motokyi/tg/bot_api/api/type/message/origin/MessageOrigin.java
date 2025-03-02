package com.motokyi.tg.bot_api.api.type.message.origin;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.MessageOriginTypes;
import lombok.Data;

/**
 * This object describes the origin of a message.
 *
 * <ul>
 *   It can be one of
 *   <li>MessageOriginUser
 *   <li>MessageOriginHiddenUser
 *   <li>MessageOriginChat
 *   <li>MessageOriginChannel
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#messageorigin">MessageOrigin</a>
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true)
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
