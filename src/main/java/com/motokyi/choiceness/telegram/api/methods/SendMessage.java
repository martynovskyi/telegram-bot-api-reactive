package com.motokyi.choiceness.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.motokyi.choiceness.telegram.api.types.Message;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.resttemplate.TelegramBotRT;
import lombok.Getter;


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
public class SendMessage extends SendMethod {

    private String text;

    public SendMessage(String chatId, TelegramBotRT rt) {
        super(chatId, rt);
    }

    public SendMessage(Long chatId, TelegramBotRT rt) {
        super(chatId, rt);
    }

    @Override
    public TLResponce<Message> send() {
        return rt.send(this);
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

    public SendMessage setReplyMarkup(String replyMarkup) {
        super.replyMarkup = replyMarkup;
        return this;
    }
}
