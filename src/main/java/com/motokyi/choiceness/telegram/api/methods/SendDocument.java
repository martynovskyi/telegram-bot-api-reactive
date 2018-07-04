package com.motokyi.choiceness.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;

/**
 * Use this method to send general files. On success, the sent Message is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
 * See <a href="SendDocument">https://core.telegram.org/bots/api#senddocument</a>
 * <p>
 * Field	            Type	            Required    Description
 * chat_id	            Integer or String	Yes	        Unique identifier for the target chat or username of the target channel (in the format @channelusername)
 * document	            InputFile or String	Yes	        File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
 * caption	            String	            Optional	Document caption (may also be used when resending documents by file_id), 0-200 characters
 * parse_mode	        String	            Optional	Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
 * disable_notification	Boolean	            Optional	Sends the message silently. Users will receive a notification with no sound.
 * reply_to_message_id	Integer	            Optional	If the message is a reply, ID of the original message
 * reply_markup	        InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
 *                                          Optional	Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendDocument extends SendMethod {

    @JsonIgnore
    private File documentFile;

    @JsonProperty("document")
    private String documentId;

    public SendDocument(String chatId) {
        super(chatId);
    }

    public SendDocument(Long chatId) {
        super(chatId);
    }
}
