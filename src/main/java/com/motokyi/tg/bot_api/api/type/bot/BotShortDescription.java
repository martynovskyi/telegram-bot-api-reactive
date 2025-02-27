package com.motokyi.tg.bot_api.api.type.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents the bot's short description.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#botshortdescription">BotShortDescription</a>
 */
@Data
public class BotShortDescription {

    @JsonProperty("short_description")
    private String shortDescription;
}
