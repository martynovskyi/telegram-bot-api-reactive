package com.motokyi.tg.bot_api.api.type.chat;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert set by another user.
 * See <a href="ProximityAlertTriggered">https://core.telegram.org/bots/api#proximityalerttriggered</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class ProximityAlertTriggered {

    private User traveler;

    private User watcher;

    private Integer distance;
}
