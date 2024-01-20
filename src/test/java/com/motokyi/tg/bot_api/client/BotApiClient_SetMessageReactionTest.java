package com.motokyi.tg.bot_api.client;

import com.motokyi.tg.bot_api.WMUtils;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.constant.ApiUrls;
import com.motokyi.tg.bot_api.api.method.payload.SetMessageReaction;
import com.motokyi.tg.bot_api.api.type.reaction.ReactionTypeEmoji;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.motokyi.tg.bot_api.WMUtils.jsonPath;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ClassNamingConvention")
public class BotApiClient_SetMessageReactionTest extends BotClientTest {
    private static final String CHAT_ID = "chat_tag";
    private static final Long MESSAGE_ID = 123L;

    @Test
    void successful() {
        SetMessageReaction setMessageReaction = new SetMessageReaction(CHAT_ID, MESSAGE_ID);
        ReactionTypeEmoji emoji = new ReactionTypeEmoji();
        emoji.setEmoji("😱");
        setMessageReaction.setReaction(List.of(emoji));
        setMessageReaction.setIsBig(Boolean.TRUE);

        stubFor(post(urlEqualTo(ApiUrls.SET_MESSAGE_REACTION))
                .withRequestBody(matchingJsonPath(jsonPath(ApiProperties.CHAT_ID), equalTo(CHAT_ID))
                        .and(matchingJsonPath(jsonPath(ApiProperties.MESSAGE_ID), equalTo(MESSAGE_ID.toString())))
                        .and(matchingJsonPath(jsonPath(ApiProperties.REACTION),
                                equalToJson("""
                                        [{"emoji": "😱"}]
                                        """)))
                        .and(matchingJsonPath(jsonPath(ApiProperties.IS_BIG), equalTo("true"))))

                .willReturn(WMUtils.jsonWithResultTrue()));

        var response = botClient.send(setMessageReaction).block();

        assertAll(
                () -> assertTrue(response.isOk()),
                () -> assertNotNull(response.getResult()),
                () -> assertTrue(response.getResult())
        );
    }

    @Test
    void unauthorized() {
        unauthorizedTest(() -> botClient.send(new SetMessageReaction(CHAT_ID, MESSAGE_ID)),
                ApiUrls.SET_MESSAGE_REACTION,
                HttpMethod.POST);
    }

    @Test
    void tooManyRequests() {
        tooManyRequestsTest(() -> botClient.send(new SetMessageReaction(CHAT_ID, MESSAGE_ID)),
                ApiUrls.SET_MESSAGE_REACTION,
                HttpMethod.POST);
    }
}
