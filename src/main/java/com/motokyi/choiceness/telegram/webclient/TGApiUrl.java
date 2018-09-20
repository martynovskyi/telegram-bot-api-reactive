package com.motokyi.choiceness.telegram.webclient;

import com.motokyi.choiceness.telegram.components.properties.TelegramBotProperties;

import static org.springframework.util.StringUtils.isEmpty;

public class TGApiUrl {
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
    private static final String API_HOST = "https://api.telegram.org";
    private static final String BOT_PREFIX = "/bot";

    public static String createHostUrl(TelegramBotProperties properties) {

        return (isEmpty(properties.apiHost) ? API_HOST : properties.apiHost)
                + BOT_PREFIX
                + properties.token;
    }
}
