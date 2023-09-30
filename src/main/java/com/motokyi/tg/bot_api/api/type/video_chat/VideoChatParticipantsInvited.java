package com.motokyi.tg.bot_api.api.type.video_chat;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

import java.util.List;

/**
 * This object represents a service message about new members invited to a video chat.
 * See <a href="VideoChatParticipantsInvited">https://core.telegram.org/bots/api#videochatparticipantsinvited</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class VideoChatParticipantsInvited {

    private List<User> users;
}
