package com.motokyi.tg.bot_api.api.type.chat;

import com.motokyi.tg.bot_api.api.type.Location;
import lombok.Data;

/**
 * Represents a location to which a chat is connected.
 * See <a href="ChatLocation">https://core.telegram.org/bots/api#chatlocation</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ChatLocation {

    private Location location;

    private String address;
}
