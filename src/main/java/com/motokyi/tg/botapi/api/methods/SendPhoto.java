package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.TGResponce;
import com.motokyi.tg.botapi.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.botapi.webclient.TGBotWebClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.function.Consumer;

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
 * Optional	Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
 */

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendPhoto extends SendMethod {
    public static final String PHOTO_ID = "photo";

    @JsonIgnore
    private File photoFile;

    @JsonProperty(PHOTO_ID)
    private String photoId;

    public SendPhoto(String chatId, TGBotWebClient rt) {
        super(chatId, rt);
    }

    public SendPhoto(Long chatId, TGBotWebClient rt) {
        super(chatId, rt);
    }

    @Override
    public Mono<TGResponce<Message>> send() {
        return wc.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<TGResponce<Message>> consumer) {
        return wc.send(this).subscribe(consumer);
    }

    public SendPhoto setPhoto(File photoFile) {
        this.photoFile = photoFile;
        return this;
    }

    public SendPhoto setPhoto(String photoId) {
        this.photoId = photoId;
        return this;
    }

    public SendPhoto setParseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendPhoto setDisableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendPhoto setDisableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendPhoto setReplyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendPhoto setReplyMarkup(KeyboardMarkup keyboardMarkup) {
        super.keyboardMarkup = keyboardMarkup;
        return this;
    }
}
