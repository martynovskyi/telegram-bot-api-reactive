package com.motokyi.tg.bot_api.bot;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@SuppressWarnings("ClassNamingConvention")
@ExtendWith(MockitoExtension.class)
class TelegramBot_BotInfoTest extends TelegramBotTestSetup {
    private static final String LANGUAGE_CODE = "uk";
    private static final String TEXT = "Unit Test Text";

    @Test
    void getMe() {
        bot.getMe();
        verify(webClient).getMe();
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyName() {
        bot.getMyName();
        verify(webClient).getMyName(null);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyName() {
        bot.setMyName(TEXT);
        verify(webClient).setMyName(TEXT, null);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyName_withLanguageCode() {
        bot.getMyName(LANGUAGE_CODE);
        verify(webClient).getMyName(LANGUAGE_CODE);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyName_withLanguageCode() {
        bot.setMyName(TEXT, LANGUAGE_CODE);
        verify(webClient).setMyName(TEXT, LANGUAGE_CODE);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyDescription() {
        bot.getMyDescription();
        verify(webClient).getMyDescription(null);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyDescription() {
        bot.setMyDescription(TEXT);
        verify(webClient).setMyDescription(TEXT, null);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyDescription_withLanguageCode() {
        bot.getMyDescription(LANGUAGE_CODE);
        verify(webClient).getMyDescription(LANGUAGE_CODE);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyDescription_withLanguageCode() {
        bot.setMyDescription(TEXT, LANGUAGE_CODE);
        verify(webClient).setMyDescription(TEXT, LANGUAGE_CODE);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyShortDescription() {
        bot.getMyShortDescription();
        verify(webClient).getMyShortDescription(null);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyShortDescription() {
        bot.setMyShortDescription(TEXT);
        verify(webClient).setMyShortDescription(TEXT, null);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyShortDescription_withLanguageCode() {
        bot.getMyShortDescription(LANGUAGE_CODE);
        verify(webClient).getMyShortDescription(LANGUAGE_CODE);
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyShortDescription_withLanguageCode() {
        bot.setMyShortDescription(TEXT, LANGUAGE_CODE);
        verify(webClient).setMyShortDescription(TEXT, LANGUAGE_CODE);
        verifyNoMoreInteractions(webClient);
    }
}
