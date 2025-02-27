package com.motokyi.tg.bot_api.api.type.background;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.BackgroundFillTypes;
import lombok.Data;

/**
 * This object describes the way a background is filled based on the selected colors.
 *
 * <ul>
 *   Currently, it can be one of
 *   <li>BackgroundFillSolid
 *   <li>BackgroundFillGradient
 *   <li>BackgroundFillFreeformGradient
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#backgroundfill">BackgroundFill</a>
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BackgroundFillSolid.class, name = BackgroundFillTypes.SOLID),
    @JsonSubTypes.Type(value = BackgroundFillGradient.class, name = BackgroundFillTypes.GRADIENT),
    @JsonSubTypes.Type(
            value = BackgroundFillFreeformGradient.class,
            name = BackgroundFillTypes.FREEFORM_GRADIENT)
})
public abstract class BackgroundFill {
    private String type;
}
