package com.motokyi.tg.bot_api.api.type.bot;

import lombok.Data;

/**
 * This object represents the bot's name.
 * <p>
 * See <a href="BotName">https://core.telegram.org/bots/api#botname</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class BotName {

    private String name;
}
