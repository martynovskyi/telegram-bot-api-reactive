package com.motokyi.tg.bot_api.api.type.bot;

import lombok.Data;

/**
 * This object represents the bot's name.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#botname">BotName</a>
 */
@Data
public class BotName {

    private String name;
}
