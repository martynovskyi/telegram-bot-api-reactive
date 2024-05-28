package com.motokyi.tg.bot_api.api.type.video_chat;

import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

import java.util.List;

/**
 * This object represents a service message about new members invited to a video chat.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#videochatparticipantsinvited">VideoChatParticipantsInvited</a>
 */
@Data
public class VideoChatParticipantsInvited {

    private List<User> users;
}
