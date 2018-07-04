package com.motokyi.choiceness.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 * See <a href="Audio">https://core.telegram.org/bots/api#audio</a>
 * <p>
 * Field	    Type	Description
 * file_id	    String	Unique identifier for this file
 * duration	    Integer	Duration of the audio in seconds as defined by sender
 * performer	String	Optional. Performer of the audio as defined by sender or by audio tags
 * title	    String	Optional. Title of the audio as defined by sender or by audio tags
 * mime_type	String	Optional. MIME type of the file as defined by sender
 * file_size	Integer	Optional. File size
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendPhoto extends SendMethod {
    @JsonIgnore
    private File photoFile;

    @JsonProperty("photo")
    private String photoId;
}
