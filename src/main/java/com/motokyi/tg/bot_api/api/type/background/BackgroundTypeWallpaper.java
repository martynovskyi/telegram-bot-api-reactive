package com.motokyi.tg.bot_api.api.type.background;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The background is a wallpaper in the JPEG format.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#backgroundtypewallpaper">BackgroundTypeWallpaper</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundTypeWallpaper extends BackgroundType {

    private Document document;

    @JsonProperty(ApiProperties.DARK_THEME_DIMMING)
    private Integer darkThemeDimming;

    @JsonProperty(ApiProperties.IS_BLURRED)
    private Boolean isBlurred;

    @JsonProperty(ApiProperties.IS_MOVING)
    private Boolean isMoving;
}
