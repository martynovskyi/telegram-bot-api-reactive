package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Describes the options used for link preview generation.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#linkpreviewoptions">LinkPreviewOptions<a/>
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkPreviewOptions {

    @JsonProperty(ApiProperties.IS_DISABLED)
    private Boolean isDisabled;

    private String url;

    @JsonProperty(ApiProperties.PREFER_SMALL_MEDIA)
    private Boolean preferSmallMedia;

    @JsonProperty(ApiProperties.PREFER_LARGE_MEDIA)
    private Boolean preferLargeMedia;

    @JsonProperty(ApiProperties.SHOW_ABOVE_TEXT)
    private Boolean showAboveText;
}
