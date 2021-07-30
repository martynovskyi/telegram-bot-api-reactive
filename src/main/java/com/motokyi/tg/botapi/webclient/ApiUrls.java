package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.components.properties.TelegramBotProperties;
import com.motokyi.tg.botapi.exception.RequiredConfigMissedException;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

public class ApiUrls {
    public static final String GET_ME = "/getMe";
    public static final String GET_CHAT = "/getChat?chat_id={chat_id}";
    public static final String GET_UPDATES = "/getUpdates";
    public static final String FORWARD_MESSAGE = "/forwardMessage";
    public static final String SEND_MESSAGE = "/sendMessage";
    public static final String SEND_PHOTO = "/sendPhoto";
    public static final String SEND_AUDIO = "/sendAudio";
    public static final String SEND_DOCUMENT = "/sendDocument";
    public static final String SEND_ANIMATION = "/sendAnimation";
    public static final String SEND_VIDEO = "/sendVideo";
    public static final String SEND_VOICE = "/sendVoice";
    public static final String SEND_VIDEO_NOTE = "/sendVideoNote";
    public static final String EDIT_MESSAGE_REPLY_MARKUP = "/editMessageReplyMarkup";
    public static final String DELETE_MESSAGE = "/deleteMessage?chat_id={chat_id}&message_id={message_id}";
    public static final String API_HOST = "https://api.telegram.org";
    public static final String BOT_PREFIX = "/bot";

    public static String createHostUrl(TelegramBotProperties properties) {
        if (isNull(properties) || !hasText(properties.token)) {
            throw new RequiredConfigMissedException("Properties not correct. Token is empty or props is null.");
        }

        return (hasText(properties.apiHost) ? properties.apiHost : API_HOST)
                + BOT_PREFIX
                + properties.token;
    }
}
