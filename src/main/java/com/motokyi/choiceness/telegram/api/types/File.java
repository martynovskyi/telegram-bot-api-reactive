package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a file ready to be downloaded. The file can be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile.
 * Maximum file size to download is 20 MB
 * See <a href="File">https://core.telegram.org/bots/api#file</a>
 * <p>
 * Field        Type	 Description
 * file_id	    String	 Unique identifier for this file
 * file_size	Integer  Optional. File size, if known
 * file_path	String   Optional. File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
 */
@Data
public class File {
    @JsonProperty("file_id")
    private String fileId;

    @JsonProperty("file_size")
    private Integer fileSize;

    @JsonProperty("file_path")
    private String filePath;
}
