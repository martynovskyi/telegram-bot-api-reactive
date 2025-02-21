package com.motokyi.tg.bot_api.api.type.chat_boost;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.ChatBoostSources;
import lombok.Data;

/**
 * This object describes the source of a chat boost.
 * <ul> It can be one of
 * <li> ChatBoostSourcePremium
 * <li> ChatBoostSourceGiftCode
 * <li> ChatBoostSourceGiveaway
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatboostsource">ChatBoostSource</a>
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "source")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChatBoostSourcePremium.class, name = ChatBoostSources.PREMIUM),
        @JsonSubTypes.Type(value = ChatBoostSourceGiftCode.class, name = ChatBoostSources.GIFT_CODE),
        @JsonSubTypes.Type(value = ChatBoostSourceGiveaway.class, name = ChatBoostSources.GIVEAWAY),
})
public abstract class ChatBoostSource {
    private String source;
}
