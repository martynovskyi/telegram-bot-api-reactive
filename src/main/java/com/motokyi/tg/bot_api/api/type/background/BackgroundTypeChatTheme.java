package com.motokyi.tg.bot_api.api.type.background;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The background is taken directly from a built-in chat theme.
 *
 * @version Bot API 8.3
 * @see <a
 *     href="https://core.telegram.org/bots/api#backgroundtypechattheme">BackgroundTypeChatTheme</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundTypeChatTheme extends BackgroundType {
    @JsonProperty(ApiProperties.THEME_NAME)
    private String themeName;
}
