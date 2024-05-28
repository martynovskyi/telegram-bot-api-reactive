package com.motokyi.tg.bot_api.api.type.background;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.BackgroundTypes;
import lombok.Data;


/**
 * This object describes the type of a background.
 *
 * <ul> Currently, it can be one of
 * <li> BackgroundTypeFill
 * <li> BackgroundTypeWallpaper
 * <li> BackgroundTypePattern
 * <li> BackgroundTypeChatTheme
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#backgroundtype">BackgroundType</a>
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BackgroundTypeFill.class, name = BackgroundTypes.FILL),
        @JsonSubTypes.Type(value = BackgroundTypeWallpaper.class, name = BackgroundTypes.WALLPAPER),
        @JsonSubTypes.Type(value = BackgroundTypePattern.class, name = BackgroundTypes.PATTERN),
        @JsonSubTypes.Type(value = BackgroundTypeChatTheme.class, name = BackgroundTypes.CHAT_THEME),
})
public abstract class BackgroundType {
    private String type;
}
