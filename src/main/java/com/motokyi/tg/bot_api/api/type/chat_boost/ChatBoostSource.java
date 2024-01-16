package com.motokyi.tg.bot_api.api.type.chat_boost;

import lombok.Data;

/**
 * This object describes the source of a chat boost. It can be one of
 * - ChatBoostSourcePremium
 * - ChatBoostSourceGiftCode
 * - ChatBoostSourceGiveaway
 * See <a href="ChatBoostSource">https://core.telegram.org/bots/api#chatboostsource</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class ChatBoostSource {
    // todo: need to review how to handle inheritance here.
    //  Probably current implementation does not work properly
    private String source;
}
