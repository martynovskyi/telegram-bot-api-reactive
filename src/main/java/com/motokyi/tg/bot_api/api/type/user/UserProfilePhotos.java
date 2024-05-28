package com.motokyi.tg.bot_api.api.type.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import lombok.Data;

import java.util.List;

/**
 * This object represent a user's profile pictures.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#userprofilephotos">UserProfilePhotos</a>
 */
@Data
public class UserProfilePhotos {

    @JsonProperty(ApiProperties.TOTAL_COUNT)
    private Integer totalCount;

    private List<List<PhotoSize>> photos;
}
