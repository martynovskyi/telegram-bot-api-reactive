package com.motokyi.tg.bot_api.api.type.background;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The background is a gradient fill.
 *
 * @version Bot API 8.3
 * @see <a href="http://core.telegram.org/bots/api#backgroundfillgradient">BackgroundFillGradient</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundFillGradient extends BackgroundFill {
    @JsonProperty(ApiProperties.TOP_COLOR)
    private Integer topColor;

    @JsonProperty(ApiProperties.BOTTOM_COLOR)
    private Integer bottomColor;

    @JsonProperty(ApiProperties.ROTATION_ANGLE)
    private Integer rotationAngle;
}
