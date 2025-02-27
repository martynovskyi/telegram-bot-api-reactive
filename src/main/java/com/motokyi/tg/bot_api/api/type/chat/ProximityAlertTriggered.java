package com.motokyi.tg.bot_api.api.type.chat;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * This object represents the content of a service message, sent whenever a user in the chat
 * triggers a proximity alert set by another user.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#proximityalerttriggered">ProximityAlertTriggered</a>
 */
@Data
public class ProximityAlertTriggered {

    private User traveler;

    private User watcher;

    private Integer distance;
}
