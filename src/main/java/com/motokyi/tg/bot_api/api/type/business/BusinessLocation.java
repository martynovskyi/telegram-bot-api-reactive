package com.motokyi.tg.bot_api.api.type.business;

import com.motokyi.tg.bot_api.api.type.Location;
import lombok.Data;

/**
 * Contains information about the location of a Telegram Business account.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#businesslocation">BusinessLocation</a>
 */
@Data
public class BusinessLocation {
    private String address;
    private Location location;
}
