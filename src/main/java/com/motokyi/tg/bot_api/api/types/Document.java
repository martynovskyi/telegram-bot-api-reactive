package com.motokyi.tg.bot_api.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files).
 * See <a href="Document">https://core.telegram.org/bots/api#document</a>
 * <p>
 * Field	    Type	    Description
 * file_id	    String	    Unique file identifier
 * thumb	    PhotoSize	Optional. Document thumbnail as defined by sender
 * file_name	String	    Optional. Original filename as defined by sender
 * mime_type	String	    Optional. MIME type of the file as defined by sender
 * file_size	Integer	    Optional. File size
 */
@Data
public class Document {

    @JsonProperty("file_id")
    private String fileId;

    private PhotoSize thumb;

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("file_size")
    private Integer fileSize;

}
