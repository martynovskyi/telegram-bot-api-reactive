package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a file ready to be downloaded. The file can be downloaded
 * via the link https://api.telegram.org/file/bot<token>/<file_path>.
 * It is guaranteed that the link will be valid for at least 1 hour. When the link expires,
 * a new one can be requested by calling getFile.
 * Maximum file size to download is 20 MB
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#file">File</a>
 */
@Data
public class File {

    @JsonProperty(ApiProperties.FILE_ID)
    private String fileId;

    @JsonProperty(ApiProperties.FILE_UNIQUE_ID)
    private String fileUniqueId;

    @JsonProperty(ApiProperties.FILE_SIZE)
    private Integer fileSize;

    @JsonProperty("file_path")
    private String filePath;
}
