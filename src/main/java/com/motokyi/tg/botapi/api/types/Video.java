package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a video file.
 * See <a href="Video">https://core.telegram.org/bots/api#video</a>
 * <p>
 * Field	    Type	    Description
 * file_id	    String	    Unique identifier for this file
 * width	    Integer	    Video width as defined by sender
 * height	    Integer	    Video height as defined by sender
 * duration	    Integer	    Duration of the video in seconds as defined by sender
 * thumb	    PhotoSize	Optional. Video thumbnail
 * mime_type	String	    Optional. Mime type of a file as defined by sender
 * file_size	Integer	    Optional. File size
 */
@Data
public class Video {

    @JsonProperty("file_id")
    private String fileId;

    private Integer width;

    private Integer height;

    private Integer duration;

    private PhotoSize thumb;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("file_size")
    private Integer fileSize;

}
