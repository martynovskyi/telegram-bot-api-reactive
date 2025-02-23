package com.motokyi.tg.bot_api.api.type.inline;

import lombok.Data;

/**
 * This object represents an inline keyboard button that copies specified text to the clipboard.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#copytextbutton">CopyTextButton</a>
 */
@Data
public class CopyTextButton {
    private String text;
}
