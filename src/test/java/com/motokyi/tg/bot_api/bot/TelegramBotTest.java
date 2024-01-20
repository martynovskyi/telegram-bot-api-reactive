package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.*;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.message.Message;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class TelegramBotTest extends TelegramBotTestSetup {

    @NotNull
    private static Message buildMessage() {
        Message message = new Message();
        message.setMessageId(MESSAGE_ID);
        message.setChat(buildChat());
        return message;
    }

    @NotNull
    private static Chat buildChat() {
        Chat chat = new Chat();
        chat.setId(CHAT_ID);
        return chat;
    }

    @Test
    void getAllUpdates() {
        bot.getAllUpdates();
        verify(webClient).getUpdates();
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getUpdates() {
        GetUpdates updates = bot.getUpdates();
        assertNotNull(updates);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getChat() {
        bot.getChat(CHAT_ID);
        verify(webClient).getChat((String.valueOf(CHAT_ID)));
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getChat_chatTag() {
        bot.getChat(CHAT_TAG);
        verify(webClient).getChat(CHAT_TAG);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendMessage() {
        SendMessage sendMessage = bot.sendMessage(CHAT_ID);
        assertNotNull(sendMessage);
        assertEquals(String.valueOf(CHAT_ID), sendMessage.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendMessage_chatTag() {
        SendMessage sendMessage = bot.sendMessage(CHAT_TAG);
        assertNotNull(sendMessage);
        assertEquals(CHAT_TAG, sendMessage.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendMessage_toChat() {
        Chat chat = buildChat();
        SendMessage sendMessage = bot.sendMessage(chat);
        assertNotNull(sendMessage);
        assertEquals(String.valueOf(chat.getId()), sendMessage.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendMessage_toNullChat() {
        assertThrows(NullPointerException.class, () -> bot.sendMessage((Chat) null));
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendMessage_withText() {
        bot.sendMessage(CHAT_ID, TEST_TEXT);
        ArgumentCaptor<SendMessage> messageCaptor = ArgumentCaptor.forClass(SendMessage.class);
        verify(webClient).send(messageCaptor.capture());
        SendMessage message = messageCaptor.getValue();
        assertAll(
                () -> assertNotNull(message),
                () -> assertEquals(String.valueOf(CHAT_ID), message.getChatId()),
                () -> assertEquals(TEST_TEXT, message.getText())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendMessage_toChatWithText() {
        bot.sendMessage(buildChat(), TEST_TEXT);
        ArgumentCaptor<SendMessage> messageCaptor = ArgumentCaptor.forClass(SendMessage.class);
        verify(webClient).send(messageCaptor.capture());
        SendMessage message = messageCaptor.getValue();
        assertAll(
                () -> assertNotNull(message),
                () -> assertEquals(String.valueOf(CHAT_ID), message.getChatId()),
                () -> assertEquals(TEST_TEXT, message.getText())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendMessage_toNullChatWithText() {
        assertThrows(NullPointerException.class, () -> bot.sendMessage((Chat) null, TEST_TEXT));
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendDocument() {
        SendDocument sendDocument = bot.sendDocument(CHAT_ID);
        assertNotNull(sendDocument);
        assertEquals(String.valueOf(CHAT_ID), sendDocument.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendDocument_chatTag() {
        SendDocument sendDocument = bot.sendDocument(CHAT_TAG);
        assertNotNull(sendDocument);
        assertEquals(CHAT_TAG, sendDocument.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendPhoto() {
        SendPhoto sendPhoto = bot.sendPhoto(CHAT_ID);
        assertNotNull(sendPhoto);
        assertEquals(String.valueOf(CHAT_ID), sendPhoto.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendPhoto_chatTag() {
        SendPhoto sendPhoto = bot.sendPhoto(CHAT_TAG);
        assertNotNull(sendPhoto);
        assertEquals(CHAT_TAG, sendPhoto.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendAnimation() {
        SendAnimation sendAnimation = bot.sendAnimation(CHAT_ID);
        assertNotNull(sendAnimation);
        assertEquals(String.valueOf(CHAT_ID), sendAnimation.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void sendAnimation_chatTag() {
        SendAnimation sendAnimation = bot.sendAnimation(CHAT_TAG);
        assertNotNull(sendAnimation);
        assertEquals(CHAT_TAG, sendAnimation.getChatId());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void forwardMessage() {
        Message message = buildMessage();
        ForwardMessage forwardMessage = bot.forwardMessage(CHAT_TAG, message);
        assertAll(
                () -> assertNotNull(forwardMessage),
                () -> assertEquals(CHAT_TAG, forwardMessage.getChatId()),
                () -> assertEquals(message.getChat().getId(), forwardMessage.getFromChatId()),
                () -> assertEquals(message.getMessageId(), forwardMessage.getMessageId())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void forwardMessage_byIds() {
        ForwardMessage forwardMessage = bot.forwardMessage(CHAT_TAG, CHAT_ID, MESSAGE_ID);
        assertAll(
                () -> assertNotNull(forwardMessage),
                () -> assertEquals(CHAT_TAG, forwardMessage.getChatId()),
                () -> assertEquals(CHAT_ID, forwardMessage.getFromChatId()),
                () -> assertEquals(MESSAGE_ID, forwardMessage.getMessageId())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void editMessageReplyMarkup() {
        EditMessageReplyMarkup editMessageReplyMarkup = bot.editMessageReplyMarkup(CHAT_ID, MESSAGE_ID);
        assertAll(
                () -> assertNotNull(editMessageReplyMarkup),
                () -> assertEquals(String.valueOf(CHAT_ID), editMessageReplyMarkup.getChatId()),
                () -> assertEquals(String.valueOf(MESSAGE_ID), editMessageReplyMarkup.getMessageId())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void deleteMessage() {
        bot.deleteMessage(CHAT_ID, MESSAGE_ID);
        verify(webClient).deleteMessage(CHAT_ID, MESSAGE_ID);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMessageReaction() {
        var setMessageReaction = bot.setMessageReaction(CHAT_TAG, MESSAGE_ID);
        assertAll(
                () -> assertNotNull(setMessageReaction),
                () -> assertEquals(CHAT_TAG, setMessageReaction.getChatId()),
                () -> assertEquals(MESSAGE_ID, setMessageReaction.getMessageId())
        );
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
                () -> assertEquals(MESSAGE_ID, setMessageReaction.getMessageId())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setWebhook() {
        String url = "https://example.com";
        SetWebhook setWebhook = bot.setWebhook(url);
        assertNotNull(setWebhook);
        assertEquals(url, setWebhook.getUrl());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void deleteWebhook() {
        DeleteWebhook deleteWebhook = bot.deleteWebhook();
        assertNotNull(deleteWebhook);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getWebhookInfo() {
        bot.getWebhookInfo();
        verify(webClient).getWebhookInfo();
        verifyNoMoreInteractions(webClient);
    }
}