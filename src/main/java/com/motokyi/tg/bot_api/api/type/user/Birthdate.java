package com.motokyi.tg.bot_api.api.type.user;

import lombok.Data;

/**
 * Describes the birthdate of a user.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#birthdate">Birthdate</a>
 */
@Data
public class Birthdate {
    private Integer day;
    private Integer month;
    private Integer year;
}
