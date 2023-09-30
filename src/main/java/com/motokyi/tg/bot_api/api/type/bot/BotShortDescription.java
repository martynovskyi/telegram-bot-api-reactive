package com.motokyi.tg.bot_api.api.type.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents the bot's short description.
 * <p>
 * See <a href="BotShortDescription">https://core.telegram.org/bots/api#botshortdescription</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class BotShortDescription {

    @JsonProperty("short_description")
    private String shortDescription;
}
