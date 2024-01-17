package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * Describes the options used for link preview generation.
 * @see <a href="https://core.telegram.org/bots/api#linkpreviewoptions">LinkPreviewOptions<a/>
 * @version Bot API 7.0
 */
@Data
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
