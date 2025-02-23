package com.motokyi.tg.bot_api.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.SendAnimation;
import com.motokyi.tg.bot_api.api.method.SendMessage;
import com.motokyi.tg.bot_api.api.method.payload.SendMethod;
import com.motokyi.tg.bot_api.api.type.LinkPreviewOptions;
import com.motokyi.tg.bot_api.api.type.inline.InlineKeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import com.motokyi.tg.bot_api.api.type.reply.ReplyParameters;
import com.motokyi.tg.bot_api.config.properties.BotConfigProperty;
import com.motokyi.tg.bot_api.exception.MissedBotConfigException;
import com.motokyi.tg.bot_api.utils.ClientUtils;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;

class ClientUtilsTest {

    private static final String API_HOST = "protocol://hostname.io";
    private static final String BOT_NAME = "test_bot";
    private static final String BOT_TOKEN = UUID.randomUUID().toString();
    private static final String CHAT_ID = "fake-chat-" + UUID.randomUUID();

    private static SendMessage buildSendMessage() {
        return new SendMessage(CHAT_ID, null)
                .messageThreadId(UUID.randomUUID().toString())
                .text(UUID.randomUUID().toString())
                .parseMode(UUID.randomUUID().toString())
                .entities(List.of(new MessageEntity()))
                .linkPreviewOptions(new LinkPreviewOptions())
                .disableNotification(true)
                .protectContent(false)
                .replyParameters(new ReplyParameters())
                .replyMarkup(new InlineKeyboardMarkup());
    }

    private static SendAnimation buildSendAnimation() {
        return new SendAnimation(CHAT_ID, null)
                .messageThreadId(UUID.randomUUID().toString())
                .animation(UUID.randomUUID().toString())
                .thumbnail(UUID.randomUUID().toString())
                .duration(2018)
                .width(800)
                .height(800)
                .caption(UUID.randomUUID().toString())
                .parseMode(UUID.randomUUID().toString())
                .replyParameters(new ReplyParameters())
                .disableNotification(true)
                .protectContent(false)
                .replyMarkup(new InlineKeyboardMarkup());
    }

    private static void assertAllMethod(
            MultiValueMap<String, HttpEntity<?>> result, SendMethod method) {
        assertAll(
                "SendMethod",
                () -> assertEquals(CHAT_ID, result.getFirst(ApiProperties.CHAT_ID).getBody()),
                () ->
                        assertThat(method.getMessageThreadId())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.MESSAGE_THREAD_ID).getBody()),
                () ->
                        assertThat(method.getReplyParameters())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.REPLY_PARAMETERS).getBody()),
                () ->
                        assertThat(method.getDisableNotification())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.DISABLE_NOTIFICATION).getBody()),
                () ->
                        assertThat(method.getParseMode())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.PARSE_MODE).getBody()),
                () -> assertNotNull(result.getFirst(ApiProperties.REPLY_MARKUP).getBody()));
    }

    private static void assertAllEmptyMethod(MultiValueMap<String, HttpEntity<?>> result) {
        assertAll(
                "SendMethod empty.",
                () -> assertEquals(CHAT_ID, result.getFirst(ApiProperties.CHAT_ID).getBody()),
                () -> assertNull(result.getFirst(ApiProperties.REPLY_PARAMETERS)),
                () -> assertNull(result.getFirst(ApiProperties.DISABLE_NOTIFICATION)),
                () -> assertNull(result.getFirst(ApiProperties.PARSE_MODE)),
                () -> assertNull(result.getFirst(ApiProperties.REPLY_MARKUP)));
    }

    private static BotConfigProperty buildValid() {
        BotConfigProperty properties = new BotConfigProperty();
        properties.setName(BOT_NAME);
        properties.setToken(BOT_TOKEN);
        properties.setApiHost(API_HOST);
        return properties;
    }

    @Test
    void insertMethodParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        var sendMessage = buildSendMessage();
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
    void insertAnimationParams() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        var sendAnimation = buildSendAnimation();
        ClientUtils.insertAnimationParams(sendAnimation, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllMethod(result, sendAnimation);
        assertAll(
                "SendAnimation",
                () ->
                        assertThat(sendAnimation.getAnimation())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.ANIMATION).getBody()),
                () ->
                        assertThat(sendAnimation.getThumbnail())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.THUMBNAIL).getBody()),
                () ->
                        assertThat(sendAnimation.getDuration())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.DURATION).getBody()),
                () ->
                        assertThat(sendAnimation.getWidth())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.WIDTH).getBody()),
                () ->
                        assertThat(sendAnimation.getHeight())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.HEIGHT).getBody()),
                () ->
                        assertThat(sendAnimation.getCaption())
                                .isNotNull()
                                .isEqualTo(result.getFirst(ApiProperties.CAPTION).getBody()));
    }

    @Test
    void insertAnimationParams_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        ClientUtils.insertAnimationParams(new SendAnimation(CHAT_ID, null), builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertAllEmptyMethod(result);
        assertAll(
                "SendAnimation empty",
                () -> assertNull(result.getFirst(ApiProperties.ANIMATION)),
                () -> assertNull(result.getFirst(ApiProperties.THUMBNAIL)),
                () -> assertNull(result.getFirst(ApiProperties.DURATION)),
                () -> assertNull(result.getFirst(ApiProperties.WIDTH)),
                () -> assertNull(result.getFirst(ApiProperties.HEIGHT)),
                () -> assertNull(result.getFirst(ApiProperties.CAPTION)));
    }

    @Test
    void createHostUrl_nullProperties() {
        assertThrows(MissedBotConfigException.class, () -> ClientUtils.createBotUrl(null));
    }

    @Test
    void createHostUrl_emptyProperties() {
        assertThrows(
                MissedBotConfigException.class, () -> ClientUtils.createBotUrl(new BotConfigProperty()));
    }

    @Test
    void createHostUrl_validProperties() {
        BotConfigProperty properties = buildValid();
        properties.setApiHost(null);
        assertTrue(properties.isValid());

        String hostUrl = ClientUtils.createBotUrl(properties);
        assertEquals(ApiUrls.API_HOST + ApiUrls.BOT_PREFIX + BOT_TOKEN, hostUrl);
    }

    @Test
    void createHostUrl_validPropertiesWithApiHost() {
        BotConfigProperty properties = buildValid();
        assertTrue(properties.isValid());

        String hostUrl = ClientUtils.createBotUrl(properties);
        assertEquals(API_HOST + ApiUrls.BOT_PREFIX + BOT_TOKEN, hostUrl);
    }
}
