package com.motokyi.tg.bot_api.api.type.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.chat.ChatAdministratorRights;
import lombok.Data;

/**
 * This object defines the criteria used to request a suitable chat.
 * The identifier of the selected chat will be shared with the bot when the corresponding button is pressed.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestchat">KeyboardButtonRequestChat</a>
 */
@Data
public class KeyboardButtonRequestChat {

    @JsonProperty(ApiProperties.REQUEST_ID)
    private Long requestId;

    @JsonProperty("chat_is_channel")
    private Boolean chatIsChannel;

    @JsonProperty("chat_is_forum")
    private Boolean chatIsForum;

    @JsonProperty("chat_has_username")
    private Boolean chatHasUsername;

    @JsonProperty("chat_is_created")
    private Boolean chatIsCreated;

    @JsonProperty("user_administrator_rights")
    private ChatAdministratorRights userAdministratorRights;

    @JsonProperty("bot_administrator_rights")
    private ChatAdministratorRights botAdministratorRights;

    @JsonProperty("bot_is_member")
    private Boolean botIsMember;
}
