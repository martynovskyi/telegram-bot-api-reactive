package com.motokyi.tg.bot_api.tools;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import com.motokyi.tg.bot_api.api.type.business.BusinessConnection;
import com.motokyi.tg.bot_api.api.type.business.BusinessMessagesDeleted;
import com.motokyi.tg.bot_api.api.type.chat.ChatJoinRequest;
import com.motokyi.tg.bot_api.api.type.chat_boost.ChatBoostRemoved;
import com.motokyi.tg.bot_api.api.type.chat_boost.ChatBoostUpdated;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMemberUpdated;
import com.motokyi.tg.bot_api.api.type.inline.ChosenInlineResult;
import com.motokyi.tg.bot_api.api.type.inline.InlineQuery;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.media.PaidMediaPurchased;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.message.MessageReactionCountUpdated;
import com.motokyi.tg.bot_api.api.type.message.MessageReactionUpdated;
import com.motokyi.tg.bot_api.api.type.payment.PreCheckoutQuery;
import com.motokyi.tg.bot_api.api.type.payment.ShippingQuery;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.poll.PollAnswer;
import com.motokyi.tg.bot_api.api.type.update.Update;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateHandlerTest {

    @Mock Consumer<Message> messageConsumer;
    @Mock Consumer<BusinessConnection> businessConnectionConsumer;
    @Mock Consumer<BusinessMessagesDeleted> businessMessagesDeletedConsumer;
    @Mock Consumer<MessageReactionUpdated> messageReactionUpdatedConsumer;
    @Mock Consumer<MessageReactionCountUpdated> messageReactionCountUpdatedConsumer;
    @Mock Consumer<InlineQuery> inlineQueryConsumer;
    @Mock Consumer<ChosenInlineResult> chosenInlineResultConsumer;
    @Mock Consumer<CallbackQuery> callbackQueryConsumer;
    @Mock Consumer<ShippingQuery> shippingQueryConsumer;
    @Mock Consumer<PreCheckoutQuery> preCheckoutQueryConsumer;
    @Mock Consumer<PaidMediaPurchased> paidMediaPurchasedConsumer;
    @Mock Consumer<Poll> pollConsumer;
    @Mock Consumer<PollAnswer> pollAnswerConsumer;
    @Mock Consumer<ChatMemberUpdated> chatMemberUpdatedConsumer;
    @Mock Consumer<ChatJoinRequest> chatJoinRequestConsumer;
    @Mock Consumer<ChatBoostUpdated> chatBoostUpdatedConsumer;
    @Mock Consumer<ChatBoostRemoved> chatBoostRemovedConsumer;

    @Test
    void apply_messageConsumer() {
        Update update = new Update();
        Message message = new Message();
        update.setMessage(message);
        UpdateHandler.builder().messageConsumer(messageConsumer).build().apply(update);

        verify(messageConsumer, only()).accept(message);
    }

    @Test
    void apply_noMessageConsumer() {
        Update update = new Update();
        update.setMessage(new Message());
        assertNoConsumer(update);
    }

    @Test
    void apply_editedMessageConsumer() {
        Update update = new Update();
        Message message = new Message();
        update.setEditedMessage(message);
        UpdateHandler.builder().editedMessageConsumer(messageConsumer).build().apply(update);

        verify(messageConsumer, only()).accept(message);
    }

    @Test
    void apply_noEditedMessageConsumer() {
        Update update = new Update();
        update.setEditedMessage(new Message());
        assertNoConsumer(update);
    }

    @Test
    void apply_channelPostConsumer() {
        Update update = new Update();
        Message message = new Message();
        update.setChannelPost(message);
        UpdateHandler.builder().channelPostConsumer(messageConsumer).build().apply(update);

        verify(messageConsumer, only()).accept(message);
    }

    @Test
    void apply_noChannelPostConsumer() {
        Update update = new Update();
        update.setChannelPost(new Message());
        assertNoConsumer(update);
    }

    @Test
    void apply_editedChannelPostConsumer() {
        Update update = new Update();
        Message message = new Message();
        update.setEditedChannelPost(message);
        UpdateHandler.builder().editedChannelPostConsumer(messageConsumer).build().apply(update);

        verify(messageConsumer, only()).accept(message);
    }

    @Test
    void apply_noEditedChannelPostConsumer() {
        Update update = new Update();
        update.setEditedChannelPost(new Message());
        assertNoConsumer(update);
    }

    @Test
    void apply_businessConnectionConsumer() {
        Update update = new Update();
        var businessConnection = new BusinessConnection();
        update.setBusinessConnection(new BusinessConnection());
        UpdateHandler.builder()
                .businessConnectionConsumer(businessConnectionConsumer)
                .build()
                .apply(update);

        verify(businessConnectionConsumer, only()).accept(businessConnection);
    }

    @Test
    void apply_noBusinessConnectionConsumer() {
        Update update = new Update();
        update.setBusinessConnection(new BusinessConnection());
        assertNoConsumer(update);
    }

    @Test
    void apply_businessMessageConsumer() {
        Update update = new Update();
        Message message = new Message();
        update.setBusinessMessage(message);
        UpdateHandler.builder().businessMessageConsumer(messageConsumer).build().apply(update);

        verify(messageConsumer, only()).accept(message);
    }

    @Test
    void apply_noBusinessMessageConsumer() {
        Update update = new Update();
        update.setBusinessMessage(new Message());
        assertNoConsumer(update);
    }

    @Test
    void apply_editedBusinessMessageConsumer() {
        Update update = new Update();
        Message message = new Message();
        update.setEditedBusinessMessage(message);
        UpdateHandler.builder().editedBusinessMessageConsumer(messageConsumer).build().apply(update);

        verify(messageConsumer, only()).accept(message);
    }

    @Test
    void apply_noEditedBusinessMessageConsumer() {
        Update update = new Update();
        update.setEditedBusinessMessage(new Message());
        assertNoConsumer(update);
    }

    @Test
    void apply_businessMessagesDeletedConsumer() {
        Update update = new Update();
        var message = new BusinessMessagesDeleted();
        update.setDeletedBusinessMessages(message);
        UpdateHandler.builder()
                .deletedBusinessMessagesConsumer(businessMessagesDeletedConsumer)
                .build()
                .apply(update);

        verify(businessMessagesDeletedConsumer, only()).accept(message);
    }

    @Test
    void apply_noBusinessMessagesDeletedConsumer() {
        Update update = new Update();
        update.setDeletedBusinessMessages(new BusinessMessagesDeleted());
        assertNoConsumer(update);
    }

    @Test
    void apply_messageReactionConsumer() {
        Update update = new Update();
        var reaction = new MessageReactionUpdated();
        update.setMessageReaction(reaction);
        UpdateHandler.builder()
                .messageReactionConsumer(messageReactionUpdatedConsumer)
                .build()
                .apply(update);

        verify(messageReactionUpdatedConsumer, only()).accept(reaction);
    }

    @Test
    void apply_noMessageReactionConsumer() {
        Update update = new Update();
        update.setMessageReaction(new MessageReactionUpdated());
        assertNoConsumer(update);
    }

    @Test
    void apply_messageReactionCountUpdatedConsumer() {
        Update update = new Update();
        var reaction = new MessageReactionCountUpdated();
        update.setMessageReactionCount(reaction);
        UpdateHandler.builder()
                .messageReactionCountUpdatedConsumer(messageReactionCountUpdatedConsumer)
                .build()
                .apply(update);

        verify(messageReactionCountUpdatedConsumer, only()).accept(reaction);
    }

    @Test
    void apply_noMessageReactionCountUpdatedConsumer() {
        Update update = new Update();
        update.setMessageReactionCount(new MessageReactionCountUpdated());
        assertNoConsumer(update);
    }

    @Test
    void apply_inlineQueryConsumer() {
        Update update = new Update();
        var inlineQuery = new InlineQuery();
        update.setInlineQuery(inlineQuery);
        UpdateHandler.builder().inlineQueryConsumer(inlineQueryConsumer).build().apply(update);

        verify(inlineQueryConsumer, only()).accept(inlineQuery);
    }

    @Test
    void apply_noInlineQueryConsumer() {
        Update update = new Update();
        update.setInlineQuery(new InlineQuery());
        assertNoConsumer(update);
    }

    @Test
    void apply_chosenInlineResultConsumer() {
        Update update = new Update();
        var result = new ChosenInlineResult();
        update.setChosenInlineResult(result);
        UpdateHandler.builder()
                .chosenInlineResultConsumer(chosenInlineResultConsumer)
                .build()
                .apply(update);

        verify(chosenInlineResultConsumer, only()).accept(result);
    }

    @Test
    void apply_noChosenInlineResultConsumer() {
        Update update = new Update();
        update.setChosenInlineResult(new ChosenInlineResult());
        assertNoConsumer(update);
    }

    @Test
    void apply_callbackQueryConsumer() {
        Update update = new Update();
        var callbackQuery = new CallbackQuery();
        update.setCallbackQuery(callbackQuery);
        UpdateHandler.builder().callbackQueryConsumer(callbackQueryConsumer).build().apply(update);

        verify(callbackQueryConsumer, only()).accept(callbackQuery);
    }

    @Test
    void apply_noCallbackQueryConsumer() {
        Update update = new Update();
        update.setCallbackQuery(new CallbackQuery());
        assertNoConsumer(update);
    }

    @Test
    void apply_shippingQueryConsumer() {
        Update update = new Update();
        var shippingQuery = new ShippingQuery();
        update.setShippingQuery(shippingQuery);
        UpdateHandler.builder().shippingQueryConsumer(shippingQueryConsumer).build().apply(update);

        verify(shippingQueryConsumer, only()).accept(shippingQuery);
    }

    @Test
    void apply_noShippingQueryConsumer() {
        Update update = new Update();
        update.setShippingQuery(new ShippingQuery());
        assertNoConsumer(update);
    }

    @Test
    void apply_preCheckoutQueryConsumer() {
        Update update = new Update();
        var preCheckoutQuery = new PreCheckoutQuery();
        update.setPreCheckoutQuery(preCheckoutQuery);
        UpdateHandler.builder()
                .preCheckoutQueryConsumer(preCheckoutQueryConsumer)
                .build()
                .apply(update);

        verify(preCheckoutQueryConsumer, only()).accept(preCheckoutQuery);
    }

    @Test
    void apply_noPreCheckoutQueryConsumer() {
        Update update = new Update();
        update.setPreCheckoutQuery(new PreCheckoutQuery());
        assertNoConsumer(update);
    }

    @Test
    void apply_purchasedPaidMediaConsumer() {
        Update update = new Update();
        var paidMediaPurchased = new PaidMediaPurchased();
        update.setPurchasedPaidMedia(paidMediaPurchased);
        UpdateHandler.builder()
                .purchasedPaidMediaConsumer(paidMediaPurchasedConsumer)
                .build()
                .apply(update);

        verify(paidMediaPurchasedConsumer, only()).accept(paidMediaPurchased);
    }

    @Test
    void apply_noPurchasedPaidMediaConsumer() {
        Update update = new Update();
        update.setPurchasedPaidMedia(new PaidMediaPurchased());
        assertNoConsumer(update);
    }

    @Test
    void apply_pollConsumer() {
        Update update = new Update();
        var poll = new Poll();
        update.setPoll(poll);
        UpdateHandler.builder().pollConsumer(pollConsumer).build().apply(update);

        verify(pollConsumer, only()).accept(poll);
    }

    @Test
    void apply_noPollConsumer() {
        Update update = new Update();
        update.setPoll(new Poll());
        assertNoConsumer(update);
    }

    @Test
    void apply_pollAnswerConsumer() {
        Update update = new Update();
        var poll = new PollAnswer();
        update.setPollAnswer(poll);
        UpdateHandler.builder().pollAnswerConsumer(pollAnswerConsumer).build().apply(update);

        verify(pollAnswerConsumer, only()).accept(poll);
    }

    @Test
    void apply_noPollAnswerConsumer() {
        Update update = new Update();
        update.setPollAnswer(new PollAnswer());
        assertNoConsumer(update);
    }

    @Test
    void apply_myChatMemberConsumer() {
        Update update = new Update();
        var chatMemberUpdated = new ChatMemberUpdated();
        update.setMyChatMember(chatMemberUpdated);
        UpdateHandler.builder().myChatMemberConsumer(chatMemberUpdatedConsumer).build().apply(update);

        verify(chatMemberUpdatedConsumer, only()).accept(chatMemberUpdated);
    }

    @Test
    void apply_noMyChatMemberConsumer() {
        Update update = new Update();
        update.setMyChatMember(new ChatMemberUpdated());
        assertNoConsumer(update);
    }

    @Test
    void apply_chatMemberConsumer() {
        Update update = new Update();
        var chatMemberUpdated = new ChatMemberUpdated();
        update.setChatMember(chatMemberUpdated);
        UpdateHandler.builder().chatMemberConsumer(chatMemberUpdatedConsumer).build().apply(update);

        verify(chatMemberUpdatedConsumer, only()).accept(chatMemberUpdated);
    }

    @Test
    void apply_noChatMemberConsumer() {
        Update update = new Update();
        update.setChatMember(new ChatMemberUpdated());
        assertNoConsumer(update);
    }

    @Test
    void apply_chatJoinRequestConsumer() {
        Update update = new Update();
        var chatJoinRequest = new ChatJoinRequest();
        update.setChatJoinRequest(chatJoinRequest);
        UpdateHandler.builder().chatJoinRequestConsumer(chatJoinRequestConsumer).build().apply(update);

        verify(chatJoinRequestConsumer, only()).accept(chatJoinRequest);
    }

    @Test
    void apply_noChatJoinRequestConsumer() {
        Update update = new Update();
        update.setChatJoinRequest(new ChatJoinRequest());
        assertNoConsumer(update);
    }

    @Test
    void apply_chatBoostUpdatedConsumer() {
        Update update = new Update();
        var chatBoostUpdated = new ChatBoostUpdated();
        update.setChatBoost(chatBoostUpdated);
        UpdateHandler.builder()
                .chatBoostUpdatedConsumer(chatBoostUpdatedConsumer)
                .build()
                .apply(update);

        verify(chatBoostUpdatedConsumer, only()).accept(chatBoostUpdated);
    }

    @Test
    void apply_noChatBoostUpdatedConsumer() {
        Update update = new Update();
        update.setChatBoost(new ChatBoostUpdated());
        assertNoConsumer(update);
    }

    @Test
    void apply_chatBoostRemovedConsumer() {
        Update update = new Update();
        var chatBoostRemoved = new ChatBoostRemoved();
        update.setRemovedChatBoost(chatBoostRemoved);
        UpdateHandler.builder()
                .chatBoostRemovedConsumer(chatBoostRemovedConsumer)
                .build()
                .apply(update);

        verify(chatBoostRemovedConsumer, only()).accept(chatBoostRemoved);
    }

    @Test
    void apply_noChatBoostRemovedConsumer() {
        Update update = new Update();
        update.setRemovedChatBoost(new ChatBoostRemoved());
        assertNoConsumer(update);
    }

    private void assertNoConsumer(Update update) {
        assertDoesNotThrow(() -> UpdateHandler.builder().build().apply(update));
        verifyNoInteractions(
                messageConsumer,
                businessConnectionConsumer,
                businessMessagesDeletedConsumer,
                messageReactionUpdatedConsumer,
                messageReactionCountUpdatedConsumer,
                inlineQueryConsumer,
                chosenInlineResultConsumer,
                callbackQueryConsumer,
                shippingQueryConsumer,
                preCheckoutQueryConsumer,
                paidMediaPurchasedConsumer,
                pollConsumer,
                pollAnswerConsumer,
                chatMemberUpdatedConsumer,
                chatJoinRequestConsumer,
                chatBoostUpdatedConsumer,
                chatBoostRemovedConsumer);
    }
}
