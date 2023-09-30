package com.motokyi.tg.bot_api.api.type.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import lombok.Data;

import java.util.List;

/**
 * This object represent a user's profile pictures.
 * See <a href="UserProfilePhotos">https://core.telegram.org/bots/api#userprofilephotos</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class UserProfilePhotos {

    @JsonProperty("total_count")
    private Integer totalCount;

    private List<PhotoSize> photos;
}
