package com.motokyi.tg.bot_api.tools;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.motokyi.tg.bot_api.TestObjects;
import com.motokyi.tg.bot_api.api.method.payload.SetMyCommands;
import com.motokyi.tg.bot_api.client.BotApiClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class BotInfoSyncTest {

    @Mock BotApiClient client;

    @InjectMocks BotInfoSync botInfoSync;

    @Test
    void sync_nothing() {
        StepVerifier.create(botInfoSync.sync()).verifyComplete();
        verifyNoInteractions(client);
    }

    @Test
    void sync_nullCommand() {
        botInfoSync.command(null);
        StepVerifier.create(botInfoSync.sync()).verifyComplete();
        verifyNoInteractions(client);
    }

    @Test
    void sync_withCommand() {
        when(client.send(any(SetMyCommands.class))).thenReturn(Mono.just(TestObjects.successTrue()));
        botInfoSync.command(new SetMyCommands());
        botInfoSync.command(new SetMyCommands());
        StepVerifier.create(botInfoSync.sync()).verifyComplete();
        verify(client, times(2)).send(any(SetMyCommands.class));
        verifyNoMoreInteractions(client);
    }

    @Test
    void sync_shortDescription() {
        when(client.setMyShortDescription(any(), any()))
                .thenReturn(Mono.just(TestObjects.successTrue()));
        botInfoSync.shortDescription("text 1", "it");
        botInfoSync.shortDescription("text 2", null);
        StepVerifier.create(botInfoSync.sync()).verifyComplete();
        verify(client, times(2)).setMyShortDescription(any(), any());
        verifyNoMoreInteractions(client);
    }

    @Test
    void sync_description() {
        when(client.setMyDescription(any(), any())).thenReturn(Mono.just(TestObjects.successTrue()));
        botInfoSync.description("desc 1", "uk");
        botInfoSync.description("desc 2", null);
        StepVerifier.create(botInfoSync.sync()).verifyComplete();
        verify(client, times(2)).setMyDescription(any(), any());
        verifyNoMoreInteractions(client);
    }

    @Test
    void sync_name() {
        when(client.setMyName(any(), any())).thenReturn(Mono.just(TestObjects.successTrue()));
        botInfoSync.name("name 1", "ua");
        botInfoSync.name("name 2", null);
        StepVerifier.create(botInfoSync.sync()).verifyComplete();
        verify(client, times(2)).setMyName(any(), any());
        verifyNoMoreInteractions(client);
    }
}
