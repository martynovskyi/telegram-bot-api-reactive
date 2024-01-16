package com.motokyi.tg.bot_api.api.type.message.origin;


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
public class MessageOrigin {

    private String type;

    private Long date;
}