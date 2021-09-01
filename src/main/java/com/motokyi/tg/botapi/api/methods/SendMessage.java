package com.motokyi.tg.botapi.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.motokyi.tg.botapi.api.types.Message;
import com.motokyi.tg.botapi.api.types.Response;
import com.motokyi.tg.botapi.api.types.markup.KeyboardMarkup;
import com.motokyi.tg.botapi.webclient.BotClient;
import lombok.Getter;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 * See <a href="SendMessage">https://core.telegram.org/bots/api#sendmessage</a>
 * <p>
 * Field	                  Type	              Required  Description
 * chat_id	                  Integer or String	  Yes	    Unique identifier for the target chat or username of the target channel (in the format @channelusername)
 * text	                      String	          Yes	    Text of the message to be sent
 * parse_mode	              String	          Optional	Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
 * disable_web_page_preview	  Boolean	          Optional	Disables link previews for links in this message
 * disable_notification	      Boolean	          Optional	Sends the message silently. Users will receive a notification with no sound.
 * reply_to_message_id	      Integer	          Optional	If the message is a reply, ID of the original message
 * reply_markup	              InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
 * Optional Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessage extends SendMethod<Response<Message>> {
    public static final String TEXT = "text";
    public static final int TEXT_LENGTH_LIMIT = 4096;

    private String text;

    public SendMessage(String chatId, BotClient rt) {
        super(chatId, rt);
    }

    public SendMessage(Long chatId, BotClient rt) {
        super(String.valueOf(chatId), rt);
    }

    @Override
    public Mono<Response<Message>> send() {
        if (text.length() > TEXT_LENGTH_LIMIT) {
            this.text = text.substring(0, TEXT_LENGTH_LIMIT);
        }
        return client.send(this);
    }

    @Override
    public Disposable subscribe(Consumer<Response<Message>> consumer) {
        return client.send(this).subscribe(consumer);
    }

    public SendMessage setText(String text) {
        this.text = text;
        return this;
    }

    public SendMessage setParseMode(String parseMode) {
        super.parseMode = parseMode;
        return this;
    }

    public SendMessage setDisableWebPagePreview(Boolean disableWebPagePreview) {
        super.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    public SendMessage setDisableNotification(Boolean disableNotification) {
        super.disableNotification = disableNotification;
        return this;
    }

    public SendMessage setReplyToMessageId(Long replyToMessageId) {
        super.replyToMessageId = replyToMessageId;
        return this;
    }

    public SendMessage setReplyMarkup(KeyboardMarkup replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
