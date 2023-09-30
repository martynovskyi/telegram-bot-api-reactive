package com.motokyi.tg.bot_api.api.type.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object describes the position on faces where a mask should be placed by default.
 * See <a href="MaskPosition">https://core.telegram.org/bots/api#maskposition</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class MaskPosition {

    private String point;

    @JsonProperty("x_shift")
    private Double xShift;

    @JsonProperty("y_shift")
    private Double yShift;

    private Double scale;
}
