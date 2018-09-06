package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * This object represent a user's profile pictures.
 * See <a href="UserProfilePhotos">https://core.telegram.org/bots/api#userprofilephotos</a>
 * <p>
 * Field        Type	                     Description
 * total_count	Integer	                     Total number of profile pictures the target user has
 * photos	    Array of Array of PhotoSize	 Requested profile pictures (in up to 4 sizes each)
 */
@Data
public class UserProfilePhotos {

    @JsonProperty("total_count")
    private Integer totalCount;

    private List<PhotoSize> photos;
}
