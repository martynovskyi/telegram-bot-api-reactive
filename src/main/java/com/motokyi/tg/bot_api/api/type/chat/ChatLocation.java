package com.motokyi.tg.bot_api.api.type.chat;

import com.motokyi.tg.bot_api.api.type.Location;
import lombok.Data;

/**
 * Represents a location to which a chat is connected.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatlocation">ChatLocation</a>
 */
@Data
public class ChatLocation {

    private Location location;

    private String address;
}
