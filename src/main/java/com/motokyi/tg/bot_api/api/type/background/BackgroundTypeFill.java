package com.motokyi.tg.bot_api.api.type.background;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The background is automatically filled based on the selected colors.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypefill">BackgroundTypeFill</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundTypeFill extends BackgroundType {

    private BackgroundFill fill;

    @JsonProperty(ApiProperties.DARK_THEME_DIMMING)
    private Integer darkThemeDimming;
}
