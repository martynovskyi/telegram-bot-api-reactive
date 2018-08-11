package com.motokyi.choiceness.telegram.resttemplate;

import com.motokyi.choiceness.telegram.components.properties.TelegramBotProperties;
import lombok.Getter;

import static org.springframework.util.StringUtils.isEmpty;

public class TelegramApiUrl {
    private static final String API_HOST = "https://api.telegram.org";

    private static final String GET_ME = "/getMe";
    private static final String GET_CHAT = "/getChat?chat_id={chat_id}";
    private static final String GET_UPDATES = "/getUpdates";
    private static final String FORWARD_MESSAGE = "/forwardMessage";
    private static final String SEND_MESSAGE = "/sendMessage";
    private static final String SEND_PHOTO = "/sendPhoto";
    private static final String SEND_AUDIO = "/sendAudio";
    private static final String SEND_DOCUMENT = "/sendDocument";
    private static final String SEND_ANIMATION = "/sendAnimation";
    private static final String SEND_VIDEO = "/sendVideo";
    private static final String SEND_VOICE = "/sendVoice";
    private static final String SEND_VIDEO_NOTE = "/sendVideoNote";

    @Getter
    private final String me;
    @Getter
    private final String chat;
    @Getter
    private final String updates;
    @Getter
    private final String forwardMessage;
    @Getter
    private final String sendMessage;
    @Getter
    private final String sendPhoto;
    @Getter
    private final String sendAudio;
    @Getter
    private final String sendDocument;
    @Getter
    private final String sendAnimation;
    @Getter
    private final String sendVideo;
    @Getter
    private final String sendVoice;
    @Getter
    private final String sendVideoNote;

    public TelegramApiUrl(TelegramBotProperties properties) {

        String host = (isEmpty(properties.apiHost) ? API_HOST : properties.apiHost)
                + "/bot"
                + properties.token;

        this.chat = host + GET_CHAT;
        this.me = host + GET_ME;
        this.updates = host + GET_UPDATES;
        this.forwardMessage = host + FORWARD_MESSAGE;
        this.sendMessage = host + SEND_MESSAGE;
        this.sendPhoto = host + SEND_PHOTO;
        this.sendAudio = host + SEND_AUDIO;
        this.sendDocument = host + SEND_DOCUMENT;
        this.sendAnimation = host + SEND_ANIMATION;
        this.sendVideo = host + SEND_VIDEO;
        this.sendVoice = host + SEND_VOICE;
        this.sendVideoNote = host + SEND_VIDEO_NOTE;
    }
}
