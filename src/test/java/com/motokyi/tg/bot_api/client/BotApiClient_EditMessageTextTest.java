package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.EditMessageText;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.inline.InlineKeyboardMarkup;
import com.motokyi.tg.bot_api.api.type.message.Message;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_EditMessageTextTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";
    private static final String MESSAGE_ID = "2450550";

    @Test
    void successful() {
        EditMessageText editMessage = buildEditMessageText();

        stubFor(post(urlEqualTo(ApiUrls.EDIT_MESSAGE_TEXT))
                .withRequestBody(
                        matchingJsonPath(WMUtils.jsonPath(ApiProperties.CHAT_ID), equalTo(CHAT_ID))
                                .and(matchingJsonPath(WMUtils.jsonPath(ApiProperties.MESSAGE_ID), equalTo(MESSAGE_ID)))
                                .and(matchingJsonPath(WMUtils.jsonPath(ApiProperties.TEXT), equalTo(editMessage.getText())))
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
                () -> botClient.send(buildEditMessageText()),
                ApiUrls.EDIT_MESSAGE_TEXT,
                HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                () -> botClient.send(buildEditMessageText()),
                ApiUrls.EDIT_MESSAGE_TEXT,
                HttpMethod.POST);
    }

    private static EditMessageText buildEditMessageText() {
        EditMessageText editMessage = new EditMessageText(CHAT_ID, MESSAGE_ID);
        editMessage.setInlineMessageId(MESSAGE_ID);
        editMessage.setText("new text");
        editMessage.setReplyMarkup(new InlineKeyboardMarkup());
        return editMessage;
    }
}
