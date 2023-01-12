package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a voice note.
 * See <a href="Voice">https://core.telegram.org/bots/api#voice</a>
 * <p>
 * Field	    Type	  Description
 * file_id	    String	  Unique identifier for this file
 * duration	    Integer	  Duration of the audio in seconds as defined by sender
 * mime_type	String	  Optional. MIME type of the file as defined by sender
 * file_size	Integer	  Optional. File size
 */
@Data
public class Voice {

    @JsonProperty("file_id")
    private String fileId;

    private Integer duration;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("file_size")
    private Integer fileSize;

}
