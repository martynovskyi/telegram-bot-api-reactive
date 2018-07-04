package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a chat photo.
 * See <a href="ChatPhoto">https://core.telegram.org/bots/api#chatphoto</a>
 * <p>
 * Field	        Type	Description
 * small_file_id	String	Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
 * big_file_id	    String	Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
 */
@Data
public class ChatPhoto {
    @JsonProperty("small_file_id")
    private String smallFileId;

    @JsonProperty("big_file_id")
    private String bigFileId;
}
