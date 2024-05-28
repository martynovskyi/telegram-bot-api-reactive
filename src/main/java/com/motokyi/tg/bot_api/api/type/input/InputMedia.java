package com.motokyi.tg.bot_api.api.type.input;

import lombok.Data;

/**
 * This object represents the content of a media message to be sent.
 *
 * <ul>It should be one of
 * <li> InputMediaAnimation
 * <li> InputMediaDocument
 * <li> InputMediaAudio
 * <li> InputMediaPhoto
 * <li> InputMediaVideo
 * </ul>
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#inputmedia">InputMedia</a>
 */
@Data
public abstract class InputMedia {
    private String type;

}
