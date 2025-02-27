package com.motokyi.tg.bot_api.api.type.background;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The background is a .PNG or .TGV (gzipped subset of SVG with MIME type
 * “application/x-tgwallpattern”) pattern to be combined with the background fill chosen by the
 * user.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypepattern">BackgroundTypePattern</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundTypePattern extends BackgroundType {

    private Document document;

    private BackgroundFill fill;

    private Integer intensity;

    @JsonProperty(ApiProperties.IS_INVERTED)
    private Boolean isInverted;

    @JsonProperty(ApiProperties.IS_MOVING)
    private Boolean isMoving;
}
