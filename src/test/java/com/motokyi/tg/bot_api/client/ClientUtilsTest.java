package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.api.ApiUrls;
import com.motokyi.tg.bot_api.api.method.SendAnimation;
import com.motokyi.tg.bot_api.api.method.SendMessage;
import com.motokyi.tg.bot_api.api.method.payload.SendMethod;
import com.motokyi.tg.bot_api.api.types.markup.InlineKeyboardMarkup;
import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.exception.RequiredConfigMissedException;
import com.motokyi.tg.bot_api.utils.ClientUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClientUtilsTest {

    private static final String BOT_NAME = "test_bot";
    private static final String BOT_TOKEN = UUID.randomUUID().toString();
    private final static String CHAT_ID = "fake-chat-" + UUID.randomUUID();
    private static SendMessage sendMessage;
    private static SendAnimation sendAnimation;

    @BeforeAll
    static void init() {
        createSendMessage();
        createSendAnimation();
    }

    private static void createSendMessage() {
        sendMessage = new SendMessage(CHAT_ID, null)
                .text(UUID.randomUUID().toString())
                .parseMode(UUID.randomUUID().toString())
                .replyToMessageId(11011L)
                .disableNotification(true)
                .disableWebPagePreview(true)
                .replyMarkup(new InlineKeyboardMarkup());
    }

    private static void createSendAnimation() {
        sendAnimation = new SendAnimation(CHAT_ID, null)
                .animation(UUID.randomUUID().toString())
                .thumbId(UUID.randomUUID().toString())
                .duration(2018)
                .width(800)
                .height(800)
                .caption(UUID.randomUUID().toString())
                .parseMode(UUID.randomUUID().toString())
                .replyToMessageId(11011L)
                .disableNotification(true)
                .disableWebPagePreview(true)
                .replyMarkup(new InlineKeyboardMarkup());
    }

    private void assertAllMethod(MultiValueMap<String, HttpEntity<?>> result, SendMethod method) {
        assertAll("SendMethod",
                () -> assertEquals(CHAT_ID, result.getFirst(SendMethod.CHAT_ID).getBody()),
                () -> assertEquals(method.getReplyToMessageId(),
                        result.getFirst(SendMethod.REPLY_TO_MESSAGE_ID).getBody()),
                () -> assertEquals(method.getDisableNotification(),
                        result.getFirst(SendMethod.DISABLE_NOTIFICATION).getBody()),
                () -> assertEquals(method.getDisableWebPagePreview(),
                        result.getFirst(SendMethod.DISABLE_WEB_PAGE_PREVIEW).getBody()),
                () -> assertEquals(method.getParseMode(), result.getFirst(SendMethod.PARSE_MODE).getBody()),
                () -> assertNotNull(result.getFirst(SendMethod.REPLY_MARKUP).getBody())
        );
    }

    private void assertAllEmptyMethod(MultiValueMap<String, HttpEntity<?>> result) {
        assertAll("SendMethod empty.",
                () -> assertEquals(CHAT_ID, result.getFirst(SendMethod.CHAT_ID).getBody()),
                () -> assertNull(result.getFirst(SendMethod.REPLY_TO_MESSAGE_ID)),
                () -> assertNull(result.getFirst(SendMethod.DISABLE_NOTIFICATION)),
                () -> assertNull(result.getFirst(SendMethod.DISABLE_WEB_PAGE_PREVIEW)),
                () -> assertNull(result.getFirst(SendMethod.PARSE_MODE)),
                () -> assertNull(result.getFirst(SendMethod.REPLY_MARKUP))
        );
    }

    @Test
    void insertMethodParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        ClientUtils.insertMethodParams(sendMessage, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllMethod(result, sendMessage);
    }

    @Test
    void insertMethodParams_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        ClientUtils.insertMethodParams(new SendMessage(CHAT_ID, null), builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllEmptyMethod(result);
    }

    @Test
    void insertMessageParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        ClientUtils.insertMessageParams(sendMessage, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllMethod(result, sendMessage);
        assertEquals(sendMessage.getText(), result.getFirst(SendMessage.TEXT).getBody());
    }

    @Test
    void insertMessageParams_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        ClientUtils.insertMessageParams(new SendMessage(CHAT_ID, null), builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllEmptyMethod(result);
        assertNull(result.getFirst(SendMessage.TEXT));
    }

    @Test
    void insertAnimationParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        ClientUtils.insertAnimationParams(sendAnimation, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllMethod(result, sendAnimation);
        assertAll("SendAnimation",
                () -> assertEquals(sendAnimation.getAnimationId(),
                        result.getFirst(SendAnimation.ANIMATION_ID).getBody()),
                () -> assertEquals(sendAnimation.getThumbId(), result.getFirst(SendAnimation.THUMB_ID).getBody()),
                () -> assertEquals(sendAnimation.getDuration(), result.getFirst(SendAnimation.DURATION).getBody()),
                () -> assertEquals(sendAnimation.getWidth(), result.getFirst(SendAnimation.WIDTH).getBody()),
                () -> assertEquals(sendAnimation.getHeight(), result.getFirst(SendAnimation.HEIGHT).getBody()),
                () -> assertEquals(sendAnimation.getCaption(), result.getFirst(SendAnimation.CAPTION).getBody())
        );
    }

    @Test
    void insertAnimationParams_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        ClientUtils.insertAnimationParams(new SendAnimation(CHAT_ID, null), builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllEmptyMethod(result);
        assertAll("SendAnimation empty",
                () -> assertNull(result.getFirst(SendAnimation.ANIMATION_ID)),
                () -> assertNull(result.getFirst(SendAnimation.THUMB_ID)),
                () -> assertNull(result.getFirst(SendAnimation.DURATION)),
                () -> assertNull(result.getFirst(SendAnimation.WIDTH)),
                () -> assertNull(result.getFirst(SendAnimation.HEIGHT)),
                () -> assertNull(result.getFirst(SendAnimation.CAPTION))
        );
    }

    @Test
    void createHostUrl_nullProperties() {
        assertThrows(RequiredConfigMissedException.class, () ->
                ClientUtils.createHostUrl(null));
    }

    @Test
    void createHostUrl_emptyProperties() {
        assertThrows(RequiredConfigMissedException.class, () ->
                ClientUtils.createHostUrl(new BotConfigProperty()));
    }

    @Test
    void createHostUrl_validProperties() {
        BotConfigProperty properties = new BotConfigProperty();
        properties.setName(BOT_NAME);
        properties.setToken(BOT_TOKEN);
        assertTrue(properties.isValid());

        String hostUrl = ClientUtils.createHostUrl(properties);
        assertEquals(ApiUrls.API_HOST + ApiUrls.BOT_PREFIX + BOT_TOKEN, hostUrl);
    }

    @Test
    void createHostUrl_validPropertiesWithApiHost() {
        String apiHost = "protocol://hostname.io";
        BotConfigProperty properties = new BotConfigProperty();
        properties.setName(BOT_NAME);
        properties.setToken(BOT_TOKEN);
        properties.setApiHost(apiHost);
        assertTrue(properties.isValid());

        String hostUrl = ClientUtils.createHostUrl(properties);
        assertEquals(apiHost + ApiUrls.BOT_PREFIX + BOT_TOKEN, hostUrl);
    }
}