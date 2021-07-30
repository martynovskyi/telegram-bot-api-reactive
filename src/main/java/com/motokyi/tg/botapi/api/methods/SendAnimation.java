package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.botapi.webclient.BotClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.function.Consumer;

/**
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
 * See <a href="SendAnimation">https://core.telegram.org/bots/api#sendanimation</a>
 * <p>
 * Field	            Type	            Required    Description
 * chat_id	            Integer or String	Yes	        Unique identifier for the target chat or username of the target channel (in the format @channelusername)
 * animation	        InputFile or String	Yes	        Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. More info on Sending Files »
 * duration	            Integer	            Optional	Duration of sent animation in seconds
 * width	            Integer	            Optional	Animation width
 * height	            Integer	            Optional	Animation height
 * thumb	            InputFile or String	Optional	Thumbnail of the file sent. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. More info on Sending Files »
 * caption	            String	            Optional	Animation caption (may also be used when resending animation by file_id), 0-200 characters
 * parse_mode	        String	            Optional	Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
 * disable_notification	Boolean	            Optional	Sends the message silently. Users will receive a notification with no sound.
 * reply_to_message_id	Integer	            Optional	If the message is a reply, ID of the original message
 * reply_markup	        InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
 * Optional	Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
 **/
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendAnimation extends SendMethod<Response<Message>> {

    public static final String ANIMATION_ID = "animation";
    public static final String THUMB_ID = "thumb";
    public static final String DURATION = "duration";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String CAPTION = "caption";

    @JsonIgnore
    private File animationFile;

    @JsonProperty(ANIMATION_ID)
    private String animationId;

    private Integer duration;

    private Integer width;

    private Integer height;

    @JsonIgnore
    private File thumb;

    @JsonProperty(THUMB_ID)
    private String thumbId;

    private String caption;

    public SendAnimation(String chatId, BotClient rt) {
        super(chatId, rt);
    }

    public SendAnimation(Long chatId, BotClient rt) {
        super(String.valueOf(chatId), rt);
    }

    @Override
    public Mono<Response<Message>> send() {
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return client.send(this).subscribe(consumer);
    }

    public SendAnimation setAnimation(File animationFile) {
        this.animationFile = animationFile;
        return this;
    }

    public SendAnimation setAnimation(String animationId) {
        this.animationId = animationId;
        return this;
    }

    public SendAnimation setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SendAnimation setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public SendAnimation setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public SendAnimation setThumb(File thumb) {
        this.thumb = thumb;
        return this;
    }

    public SendAnimation setThumbId(String thumbId) {
        this.thumbId = thumbId;
        return this;
    }

    public SendAnimation setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SendAnimation setParseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendAnimation setDisableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendAnimation setDisableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendAnimation setReplyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendAnimation setReplyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
