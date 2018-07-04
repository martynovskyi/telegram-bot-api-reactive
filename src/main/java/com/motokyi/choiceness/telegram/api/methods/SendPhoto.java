package com.motokyi.choiceness.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Use this method to send photos. On success, the sent Message is returned.
 * See <a href="SendPhoto">https://core.telegram.org/bots/api#audio</a>
 * <p>
 * Field	            Type	             Required   Description
 * chat_id	            Integer or String	 Yes	    Unique identifier for the target chat or username of the target channel (in the format @channelusername)
 * photo	            InputFile or String	 Yes	    Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. More info on Sending Files »
 * caption	            String	             Optional	Photo caption (may also be used when resending photos by file_id), 0-200 characters
 * parse_mode	        String	             Optional	Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
 * disable_notification	Boolean	             Optional	Sends the message silently. Users will receive a notification with no sound.
 * reply_to_message_id	Integer	             Optional	If the message is a reply, ID of the original message
 * reply_markup	        InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
 *                                           Optional	Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendPhoto extends SendMethod {
    @JsonIgnore
    private File photoFile;

    @JsonProperty("photo")
    private String photoId;

    public SendPhoto(String chatId) {
        super(chatId);
    }

    public SendPhoto(Long chatId) {
        super(chatId);
    }
}
