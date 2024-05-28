package com.motokyi.tg.bot_api.api.type.keyboard;

import lombok.Data;

/**
 * This object represents type of a poll, which is allowed to be created
 * and sent when the corresponding button is pressed.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonpolltype">KeyboardButtonPollType</a>
 */
@Data
public class KeyboardButtonPollType {

    private String type;
}
