package com.motokyi.tg.bot_api.api.type.bot;

import lombok.Data;

/**
 * This object represents the bot's description.
 * <p>
 * See <a href="BotDescription">https://core.telegram.org/bots/api#botdescription</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class BotDescription {

    private String description;
}
