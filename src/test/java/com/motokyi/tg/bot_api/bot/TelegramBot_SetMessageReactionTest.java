package com.motokyi.tg.bot_api.bot;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.motokyi.tg.bot_api.api.method.SetMessageReaction;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.message.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

@SuppressWarnings("ClassNamingConvention")
@ExtendWith(MockitoExtension.class)
public class TelegramBot_SetMessageReactionTest extends TelegramBotTestSetup {

    @Test
    void setMessageReactionChatTag() {
        var setMessageReaction = bot.setMessageReaction(CHAT_TAG, MESSAGE_ID);
        assertAll(
                () -> assertNotNull(setMessageReaction),
                () -> assertEquals(CHAT_TAG, setMessageReaction.getChatId()),
                () -> assertEquals(MESSAGE_ID, setMessageReaction.getMessageId()));
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMessageReaction() {
        var setMessageReaction = bot.setMessageReaction(CHAT_ID, MESSAGE_ID);
        assertAll(
                () -> assertNotNull(setMessageReaction),
                () -> assertEquals(CHAT_ID.toString(), setMessageReaction.getChatId()),
                () -> assertEquals(MESSAGE_ID, setMessageReaction.getMessageId()));
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMessageReactionWithObjects() {
        Chat chat = new Chat();
        chat.setId(CHAT_ID);
        Message message = new Message();
        message.setMessageId(MESSAGE_ID);
        var setMessageReaction = bot.setMessageReaction(chat, message);
        assertAll(
                () -> assertNotNull(setMessageReaction),
                () -> assertEquals(CHAT_ID.toString(), setMessageReaction.getChatId()),
                () -> assertEquals(MESSAGE_ID, setMessageReaction.getMessageId()));
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void dropMessageReaction() {
        bot.dropMessageReaction(CHAT_TAG, MESSAGE_ID);
        var captor = ArgumentCaptor.forClass(SetMessageReaction.class);
        verify(webClient).send(captor.capture());
        SetMessageReaction setMessageReaction = captor.getValue();
        assertAll(
                () -> assertNotNull(setMessageReaction),
                () -> assertEquals(CHAT_TAG, setMessageReaction.getChatId()),
                () -> assertEquals(MESSAGE_ID, setMessageReaction.getMessageId()));
        verifyNoMoreInteractions(webClient);
    }
}
