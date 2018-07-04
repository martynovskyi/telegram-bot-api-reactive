package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 * See <a href="VideoNote">https://core.telegram.org/bots/api#videonote</a>
 * <p>
 * Field	    Type	    Description
 * file_id	    String	    Unique identifier for this file
 * length	    Integer 	Video width and height as defined by sender
 * duration	    Integer	    Duration of the video in seconds as defined by sender
 * thumb	    PhotoSize	Optional. Video thumbnail
 * file_size	Integer	    Optional. File size
 */
@Data
public class VideoNote {

    @JsonProperty("file_id")
    private String fileId;

    private Integer length;

    private Integer duration;

    private PhotoSize thumb;

    @JsonProperty("file_size")
    private Integer fileSize;

}
