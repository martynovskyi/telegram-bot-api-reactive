package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * You can provide an animation for your game so that it looks stylish in chats (check out Lumberjack for an example). This object represents an animation file to be displayed in the message containing a game.
 * See <a href="Animation">https://core.telegram.org/bots/api#animation</a>
 * <p>
 * Field	    Type	    Description
 * file_id	    String	    Unique file identifier
 * thumb	    PhotoSize	Optional. Animation thumbnail as defined by sender
 * file_name    String	    Optional. Original animation filename as defined by sender
 * mime_type    String	    Optional. MIME type of the file as defined by sender
 * file_size    Integer	    Optional. File size
 */
@Data
public class Animation {

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
