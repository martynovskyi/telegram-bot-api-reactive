package com.motokyi.tg.botapi.webclient;

import com.motokyi.tg.botapi.api.methods.SendAnimation;
import com.motokyi.tg.botapi.api.methods.SendMessage;
import com.motokyi.tg.botapi.api.methods.SendMethod;
import com.motokyi.tg.botapi.api.types.markup.InlineKeyboardMarkup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TGWebClientUtilsTest {

    private final static String CHAT_ID = "fake-chat-" + UUID.randomUUID();
    public static final String KEY = "key";
    public static final String VALUE = "value";
    private static SendMessage sendMessage;
    private static SendAnimation sendAnimation;

    @BeforeAll
    static void init() {
        createSendMessage();
        createSendAnimation();

    }


    private static void createSendMessage() {
        sendMessage = new SendMessage(CHAT_ID, null)
                .setText(UUID.randomUUID().toString())
                .setParseMode(UUID.randomUUID().toString())
                .setReplyToMessageId(11011L)
                .setDisableNotification(true)
                .setDisableWebPagePreview(true)
                .setReplyMarkup(new InlineKeyboardMarkup());
    }

    private static void createSendAnimation() {
        sendAnimation = new SendAnimation(CHAT_ID, null)
                .setAnimation(UUID.randomUUID().toString())
                .setThumbId(UUID.randomUUID().toString())
                .setDuration(2018)
                .setWidth(800)
                .setHeight(800)
                .setCaption(UUID.randomUUID().toString())
                .setParseMode(UUID.randomUUID().toString())
                .setReplyToMessageId(11011L)
                .setDisableNotification(true)
                .setDisableWebPagePreview(true)
                .setReplyMarkup(new InlineKeyboardMarkup());
    }

    private void assertAllMethod(MultiValueMap<String, HttpEntity<?>> result, SendMethod method) {
        assertAll("SendMethod",
                () -> assertEquals(CHAT_ID, result.getFirst(SendMethod.CHAT_ID).getBody()),
                () -> assertEquals(method.getReplyToMessageId(), result.getFirst(SendMethod.REPLY_TO_MESSAGE_ID).getBody()),
                () -> assertEquals(method.getDisableNotification(), result.getFirst(SendMethod.DISABLE_NOTIFICATION).getBody()),
                () -> assertEquals(method.getDisableWebPagePreview(), result.getFirst(SendMethod.DISABLE_WEB_PAGE_PREVIEW).getBody()),
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
    void insertString() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertString(KEY, VALUE, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertEquals(VALUE, result.getFirst(KEY).getBody());
    }

    @Test
    void insertString_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertString(null, VALUE, builder);
        TGWebClientUtils.insertString(KEY, null, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertTrue(result.isEmpty());
    }

    @Test
    void insertObject() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        Object value = new Object();
        TGWebClientUtils.insertObject(KEY, value, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertEquals(value, result.getFirst(KEY).getBody());
    }

    @Test
    void insertObject_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertObject(null, VALUE, builder);
        TGWebClientUtils.insertObject(KEY, null, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertTrue(result.isEmpty());
    }


    @Test
    void insertMethodParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertMethodParams(sendMessage, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllMethod(result, sendMessage);
    }

    @Test
    void insertMethodParams_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertMethodParams(new SendMessage(CHAT_ID, null), builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllEmptyMethod(result);
    }

    @Test
    void insertMessageParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertMessageParams(sendMessage, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllMethod(result, sendMessage);
        assertEquals(sendMessage.getText(), result.getFirst(SendMessage.TEXT).getBody());
    }

    @Test
    void insertMessageParams_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertMessageParams(new SendMessage(CHAT_ID, null), builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllEmptyMethod(result);
        assertNull(result.getFirst(SendMessage.TEXT));
    }

    @Test
    void insertAnimationParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        TGWebClientUtils.insertAnimationParams(sendAnimation, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllMethod(result, sendAnimation);
        assertAll("SendAnimation",
                () -> assertEquals(sendAnimation.getAnimationId(), result.getFirst(SendAnimation.ANIMATION_ID).getBody()),
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
        TGWebClientUtils.insertAnimationParams(new SendAnimation(CHAT_ID, null), builder);
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

}