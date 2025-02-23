package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.EditMessageReplyMarkup;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.inline.InlineKeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_EditMessageReplyMarkupTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";
    private static final String MESSAGE_ID = "2450550";


    @Test
    void successful() {
        EditMessageReplyMarkup editMessage = buildEditMessageReplyMarkup();

        stubFor(post(urlEqualTo(ApiUrls.EDIT_MESSAGE_REPLY_MARKUP))
                .withRequestBody(
                        matchingJsonPath(WMUtils.jsonPath(ApiProperties.CHAT_ID), equalTo(CHAT_ID))
                                .and(matchingJsonPath(WMUtils.jsonPath(ApiProperties.MESSAGE_ID), equalTo(MESSAGE_ID)))
                                .and(matchingJsonPath(WMUtils.jsonPath(ApiProperties.INLINE_MESSAGE_ID), equalTo(MESSAGE_ID)))
                                .and(matchingJsonPath(WMUtils.jsonPath(ApiProperties.REPLY_MARKUP), equalToJson("{ }")))
                )
                .willReturn(WMUtils.jsonWithResultMessage()));


        Response<Message> response = botClient.send(editMessage).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertNotNull(response.getResult().getMessageId()),
                () -> assertNotNull(response.getResult().getFrom()),
                () -> assertNotNull(response.getResult().getChat())
        );
    }


    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.send(buildEditMessageReplyMarkup()),
                ApiUrls.EDIT_MESSAGE_REPLY_MARKUP,
                HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.send(buildEditMessageReplyMarkup()),
                ApiUrls.EDIT_MESSAGE_REPLY_MARKUP,
                HttpMethod.POST);
    }

    private static EditMessageReplyMarkup buildEditMessageReplyMarkup() {
        EditMessageReplyMarkup editMessage = new EditMessageReplyMarkup(CHAT_ID, MESSAGE_ID);
        editMessage.setInlineMessageId(MESSAGE_ID);
        editMessage.setReplyMarkup(new InlineKeyboardMarkup());
        return editMessage;
    }
}
