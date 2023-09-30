package com.motokyi.tg.bot_api.api.type.keyboard;

import lombok.Data;

/**
 * This object represents type of a poll, which is allowed to be created
 * and sent when the corresponding button is pressed.
 * See <a href="KeyboardButtonPollType">https://core.telegram.org/bots/api#keyboardbuttonpolltype</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class KeyboardButtonPollType {

    private String type;
}
