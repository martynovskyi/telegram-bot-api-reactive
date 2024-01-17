package com.motokyi.tg.bot_api.api.type.bot;

import lombok.Data;

/**
 * This object represents the bot's description.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#botdescription">BotDescription</a>
 */
@Data
public class BotDescription {

    private String description;
}
