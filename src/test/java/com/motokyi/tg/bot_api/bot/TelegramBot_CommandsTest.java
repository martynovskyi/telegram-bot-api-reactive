package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.TestObjects;
import com.motokyi.tg.bot_api.api.method.DeleteMyCommands;
import com.motokyi.tg.bot_api.api.method.GetMyCommands;
import com.motokyi.tg.bot_api.api.method.SetMyCommands;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScopes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings("ClassNamingConvention")
@ExtendWith(MockitoExtension.class)
class TelegramBot_CommandsTest extends TelegramBotTestSetup {
    private static final String LANGUAGE_CODE = "uk";

    @Test
    void getMyCommands_NoArgs() {
        GetMyCommands getMyCommands = bot.getMyCommands();
        assertNotNull(getMyCommands);
        verifyNoInteractions(webClient);
    }

    @Test
    void getMyCommands_sendPayload() {
        var getCaptor = ArgumentCaptor.forClass(com.motokyi.tg.bot_api.api.method.payload.GetMyCommands.class);
        var expectedPayload = new com.motokyi.tg.bot_api.api.method.payload.GetMyCommands();
        bot.send(expectedPayload);

        verify(webClient).send(getCaptor.capture());
        assertEquals(expectedPayload, getCaptor.getValue());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyCommands_sendNullPayload() {
        assertThrows(NullPointerException.class, () -> bot.send((com.motokyi.tg.bot_api.api.method.payload.GetMyCommands) null));
        verifyNoInteractions(webClient);
    }

    @Test
    void getMyCommand_WithScope() {
        bot.getMyCommands(BotCommandScopes.DEFAULT);
        ArgumentCaptor<GetMyCommands> getCaptor = ArgumentCaptor.forClass(GetMyCommands.class);

        verify(webClient).send(getCaptor.capture());
        GetMyCommands getMyCommands = getCaptor.getValue();
        assertAll(
                () -> assertNotNull(getMyCommands),
                () -> assertEquals(BotCommandScopes.DEFAULT, getMyCommands.getScope())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void getMyCommand_WithScopeAndLanguage() {
        bot.getMyCommands(BotCommandScopes.DEFAULT, LANGUAGE_CODE);
        ArgumentCaptor<GetMyCommands> getCaptor = ArgumentCaptor.forClass(GetMyCommands.class);

        verify(webClient).send(getCaptor.capture());
        GetMyCommands getMyCommands = getCaptor.getValue();
        assertAll(
                () -> assertNotNull(getMyCommands),
                () -> assertEquals(BotCommandScopes.DEFAULT, getMyCommands.getScope()),
                () -> assertEquals(LANGUAGE_CODE, getMyCommands.getLanguageCode())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyCommands() {
        SetMyCommands setMyCommands = bot.setMyCommands();
        assertNotNull(setMyCommands);
        verifyNoInteractions(webClient);
    }

    @Test
    void setMyCommands_sendPayload() {
        var getCaptor = ArgumentCaptor.forClass(com.motokyi.tg.bot_api.api.method.payload.SetMyCommands.class);
        var expectedPayload = new com.motokyi.tg.bot_api.api.method.payload.SetMyCommands();
        bot.send(expectedPayload);

        verify(webClient).send(getCaptor.capture());
        assertEquals(expectedPayload, getCaptor.getValue());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void setMyCommands_sendNullPayload() {
        assertThrows(NullPointerException.class, () -> bot.send((com.motokyi.tg.bot_api.api.method.payload.SetMyCommands) null));
        verifyNoInteractions(webClient);
    }

    @Test
    void deleteMyCommands() {
        DeleteMyCommands deleteMyCommands = bot.deleteMyCommands();
        assertNotNull(deleteMyCommands);
        verifyNoInteractions(webClient);
    }

    @Test
    void deleteMyCommands_sendPayload() {
        var getCaptor = ArgumentCaptor.forClass(com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands.class);
        var expectedPayload = new com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands();
        bot.send(expectedPayload);

        verify(webClient).send(getCaptor.capture());
        assertEquals(expectedPayload, getCaptor.getValue());
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void deleteMyCommands_sendNullPayload() {
        assertThrows(NullPointerException.class, () -> bot.send((com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands) null));
        verifyNoInteractions(webClient);
    }

    @Test
    void deleteMyCommands_WithScope() {
        ArgumentCaptor<DeleteMyCommands> deleteCaptor = ArgumentCaptor.forClass(DeleteMyCommands.class);
        Response<Boolean> response = TestObjects.successTrue();
        when(webClient.send(any(DeleteMyCommands.class))).thenReturn(Mono.just(response));

        StepVerifier.create(bot.deleteMyCommands(BotCommandScopes.DEFAULT))
                .expectNext(response);

        verify(webClient).send(deleteCaptor.capture());
        DeleteMyCommands deleteMyCommands = deleteCaptor.getValue();
        assertAll(
                () -> assertNotNull(deleteMyCommands),
                () -> assertEquals(BotCommandScopes.DEFAULT, deleteMyCommands.getScope())
        );
        verifyNoMoreInteractions(webClient);
    }

    @Test
    void deleteMyCommands_WithScopeAndLanguage() {
        ArgumentCaptor<DeleteMyCommands> deleteCaptor = ArgumentCaptor.forClass(DeleteMyCommands.class);
        Response<Boolean> response = TestObjects.successTrue();
        when(webClient.send(any(DeleteMyCommands.class))).thenReturn(Mono.just(response));

        StepVerifier.create(bot.deleteMyCommands(BotCommandScopes.DEFAULT, LANGUAGE_CODE))
                .expectNext(response);

        verify(webClient).send(deleteCaptor.capture());
        DeleteMyCommands deleteMyCommands = deleteCaptor.getValue();
        assertAll(
                () -> assertNotNull(deleteMyCommands),
                () -> assertEquals(BotCommandScopes.DEFAULT, deleteMyCommands.getScope()),
                () -> assertEquals(LANGUAGE_CODE, deleteMyCommands.getLanguageCode())
        );
        verifyNoMoreInteractions(webClient);
    }


}