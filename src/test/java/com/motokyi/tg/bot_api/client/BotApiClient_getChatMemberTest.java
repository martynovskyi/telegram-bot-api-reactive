package com.motokyi.tg.bot_api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberBanned;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberMember;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberOwner;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_getChatMemberTest extends BotClientTest {
    private static final String CHAT_ID = "test_chat";
    private static final Long USER_ID = 11223L;

    @Test
    void successful_member() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.GET_CHAT_MEMBER))
                        .withQueryParam(ApiProperties.CHAT_ID, equalTo(CHAT_ID))
                        .withQueryParam(ApiProperties.USER_ID, equalTo(USER_ID.toString()))
                        .willReturn(WMUtils.fromJsonFile("body/chat-member-member.json")));

        var response = botClient.getChatMember(CHAT_ID, USER_ID).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertInstanceOf(ChatMemberMember.class, response.getResult()));
    }

    @Test
    void successful_creator() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.GET_CHAT_MEMBER))
                        .withQueryParam(ApiProperties.CHAT_ID, equalTo(CHAT_ID))
                        .withQueryParam(ApiProperties.USER_ID, equalTo(USER_ID.toString()))
                        .willReturn(WMUtils.fromJsonFile("body/chat-member-creator.json")));

        var response = botClient.getChatMember(CHAT_ID, USER_ID).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertInstanceOf(ChatMemberOwner.class, response.getResult()));
    }

    @Test
    void successful_kicked() {
        stubFor(
                get(urlPathEqualTo(ApiUrls.GET_CHAT_MEMBER))
                        .withQueryParam(ApiProperties.CHAT_ID, equalTo(CHAT_ID))
                        .withQueryParam(ApiProperties.USER_ID, equalTo(USER_ID.toString()))
                        .willReturn(WMUtils.fromJsonFile("body/chat-member-kicked.json")));

        var response = botClient.getChatMember(CHAT_ID, USER_ID).block();
        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertInstanceOf(ChatMemberBanned.class, response.getResult()));
    }

    @Test
    void unauthorized() {
        unauthorizedTest(
                botClient.getChatMember(CHAT_ID, USER_ID), ApiUrls.GET_CHAT_MEMBER, HttpMethod.GET);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(
                botClient.getChatMember(CHAT_ID, USER_ID), ApiUrls.GET_CHAT_MEMBER, HttpMethod.GET);
    }
}
