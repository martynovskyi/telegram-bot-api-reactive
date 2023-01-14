package com.motokyi.tg.bot_api.api.constant;

public final class ApiUrls {
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
    public static final String SET_MY_COMMANDS = "/setMyCommands";
    public static final String DELETE_MY_COMMANDS = "/deleteMyCommands";
    public static final String GET_MY_COMMANDS = "/getMyCommands";
    public static final String DELETE_MESSAGE = "/deleteMessage?chat_id={chat_id}&message_id={message_id}";
    public static final String API_HOST = "https://api.telegram.org";
    public static final String BOT_PREFIX = "/bot";
    public static final String SET_WEBHOOK = "/setWebhook";
    public static final String DELETE_WEBHOOK = "/deleteWebhook";
    public static final String GET_WEBHOOK_INFO = "/getWebhookInfo";
}