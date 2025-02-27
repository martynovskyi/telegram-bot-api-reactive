package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import java.util.List;
import lombok.Data;

/**
 * This object contains information about the chat whose identifier was shared with the bot using a
 * KeyboardButtonRequestChat button.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatshared">ChatShared</a>
 */
@Data
public class ChatShared {

    @JsonProperty(ApiProperties.REQUEST_ID)
    private Long requestId;

    @JsonProperty(ApiProperties.CHAT_ID)
    private Long chatId;

    private String title;

    private String username;

    private List<PhotoSize> photo;
}
