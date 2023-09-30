package com.motokyi.tg.bot_api.api.type.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents an inline button that switches the current user to inline mode in a chosen chat,
 * with an optional default inline query.
 * See <a href="SwitchInlineQueryChosenChat">https://core.telegram.org/bots/api#switchinlinequerychosenchat</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class SwitchInlineQueryChosenChat {

    private String query;

    @JsonProperty("allow_user_chats")
    private Boolean allowUserChats;

    @JsonProperty("allow_bot_chats")
    private Boolean allowBotChats;

    @JsonProperty("allow_group_chats")
    private Boolean allowGroupChats;

    @JsonProperty("allow_channel_chats")
    private Boolean allowChannelChats;
}
