package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.*;
import com.motokyi.tg.bot_api.api.type.Chat;
import com.motokyi.tg.bot_api.api.type.Message;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import com.motokyi.tg.bot_api.client.BotApiClient;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class TelegramBotTest {
    private static final Long CHAT_ID = 2023L;
    private static final String CHAT_TAG = "test_chat";
    public static final long MESSAGE_ID = 5445L;
    @Mock
    BotApiClient webClient;

    @InjectMocks
    private TelegramBot bot;

    @Test
    void getMe() {
        bot.getMe();
        verify(webClient).getMe();
        verifyNoMoreInteractions(webClient);
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
    void sendMessage_withText() {
        String text = "text";
        bot.sendMessage(CHAT_ID, text);
        ArgumentCaptor<SendMessage> messageCaptor = ArgumentCaptor.forClass(SendMessage.class);
        verify(webClient).send(messageCaptor.capture());
        SendMessage message = messageCaptor.getValue();
        assertAll(
                () -> assertNotNull(message),
                () -> assertEquals(String.valueOf(CHAT_ID), message.getChatId()),
                () -> assertEquals(text, message.getText())
        );
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
    void setMyCommands() {
        SetMyCommands setMyCommands = bot.setMyCommands();
        assertNotNull(setMyCommands);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void deleteMyCommands() {
        BotCommandScope scope = new BotCommandScope();
        bot.deleteMyCommands(scope);
        ArgumentCaptor<DeleteMyCommands> deleteCaptor = ArgumentCaptor.forClass(DeleteMyCommands.class);
        verify(webClient).send(deleteCaptor.capture());
        DeleteMyCommands deleteMyCommands = deleteCaptor.getValue();
        assertAll(
                () -> assertNotNull(deleteMyCommands),
                () -> assertEquals(scope, deleteMyCommands.getScope())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyCommands() {
        BotCommandScope scope = new BotCommandScope();
        bot.getMyCommands(scope);
        ArgumentCaptor<GetMyCommands> deleteCaptor = ArgumentCaptor.forClass(GetMyCommands.class);
        verify(webClient).send(deleteCaptor.capture());
        GetMyCommands getMyCommands = deleteCaptor.getValue();
        assertAll(
                () -> assertNotNull(getMyCommands),
                () -> assertEquals(scope, getMyCommands.getScope())
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


    @NotNull
    private static Message buildMessage() {
        Message message = new Message();
        message.setMessageId(MESSAGE_ID);
        Chat chat = new Chat();
        chat.setId(CHAT_ID);
        message.setChat(chat);
        return message;
    }
}