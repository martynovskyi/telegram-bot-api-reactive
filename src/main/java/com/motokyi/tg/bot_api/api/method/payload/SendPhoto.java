package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Use this method to send photos. On success, the sent Message is returned.
 *
 * @version Bot API 6.9
 * @see <a href="https://core.telegram.org/bots/api#sendphoto">sendPhoto</a>
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendPhoto extends SendMethod {
    public static final String PHOTO_ID = "photo";

    @JsonIgnore
    private File photoFile;

    @JsonProperty(PHOTO_ID)
    private String photoId;

    public SendPhoto(String chatId) {
        super(chatId);
    }
}
