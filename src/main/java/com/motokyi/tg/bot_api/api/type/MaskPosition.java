package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object describes the position on faces where a mask should be placed by default.
 * See <a href="MaskPosition">https://core.telegram.org/bots/api#maskposition</a>
 * <p>
 * Field	Type        Description
 * point	String       	The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
 * x_shift	Float number	Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
 * y_shift	Float number	Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
 * scale	Float number	Mask scaling coefficient. For example, 2.0 means double size.
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
