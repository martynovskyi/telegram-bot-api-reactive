package com.motokyi.tg.bot_api.bot;

import com.motokyi.tg.bot_api.api.method.*;
import com.motokyi.tg.bot_api.api.type.Response;
import com.motokyi.tg.bot_api.api.type.bot.BotDescription;
import com.motokyi.tg.bot_api.api.type.bot.BotName;
import com.motokyi.tg.bot_api.api.type.bot.BotShortDescription;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.chat.ChatFullInfo;
import com.motokyi.tg.bot_api.api.type.chat_member.ChatMember;
import com.motokyi.tg.bot_api.api.type.command.BotCommand;
import com.motokyi.tg.bot_api.api.type.command.BotCommandScope;
import com.motokyi.tg.bot_api.api.type.markup.CallbackQuery;
import com.motokyi.tg.bot_api.api.type.message.Message;
import com.motokyi.tg.bot_api.api.type.update.Update;
import com.motokyi.tg.bot_api.api.type.update.WebhookInfo;
import com.motokyi.tg.bot_api.api.type.user.User;
import com.motokyi.tg.bot_api.client.BotApiClient;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TelegramBot implements Bot {
    public static final String VALUE_MUST_BE_NOT_NULL = " value must be Not Null";
    private final BotApiClient client;

    @Override
    public Mono<Response<User>> getMe() {
        return client.getMe();
    }

    @Override
    public Mono<Response<BotName>> getMyName() {
        return client.getMyName(null);
    }

    @Override
    public Mono<Response<Boolean>> setMyName(String name) {
        return client.setMyName(name, null);
    }

    @Override
    public Mono<Response<BotName>> getMyName(String languageCode) {
        return client.getMyName(languageCode);
    }

    @Override
    public Mono<Response<Boolean>> setMyName(String name, String languageCode) {
        return client.setMyName(name, languageCode);
    }

    @Override
    public Mono<Response<BotDescription>> getMyDescription() {
        return client.getMyDescription(null);
    }

    @Override
    public Mono<Response<Boolean>> setMyDescription(String description) {
        return client.setMyDescription(description, null);
    }

    @Override
    public Mono<Response<BotDescription>> getMyDescription(String languageCode) {
        return client.getMyDescription(languageCode);
    }

    @Override
    public Mono<Response<Boolean>> setMyDescription(String description, String languageCode) {
        return client.setMyDescription(description, languageCode);
    }

    @Override
    public Mono<Response<BotShortDescription>> getMyShortDescription() {
        return client.getMyShortDescription(null);
    }

    @Override
    public Mono<Response<Boolean>> setMyShortDescription(String shortDescription) {
        return client.setMyShortDescription(shortDescription, null);
    }

    @Override
    public Mono<Response<BotShortDescription>> getMyShortDescription(String languageCode) {
        return client.getMyShortDescription(languageCode);
    }

    @Override
    public Mono<Response<Boolean>> setMyShortDescription(
            String shortDescription, String languageCode) {
        return client.setMyShortDescription(shortDescription, languageCode);
    }

    @Override
    public Mono<Response<List<Update>>> getAllUpdates() {
        return client.getUpdates();
    }

    @Override
    public GetUpdates getUpdates() {
        return new GetUpdates(client);
    }

    @Override
    public Mono<Response<ChatFullInfo>> getChat(@NotNull Long chatId) {
        return client.getChat(String.valueOf(chatId));
    }

    @Override
    public Mono<Response<ChatFullInfo>> getChat(@NotNull String chatTag) {
        return client.getChat(chatTag);
    }

    @Override
    public Mono<Response<Boolean>> leaveChat(@NotNull Long chatId) {
        return client.leaveChat(String.valueOf(chatId));
    }

    @Override
    public Mono<Response<Boolean>> leaveChat(@NotNull String chatId) {
        return client.leaveChat(chatId);
    }

    @Override
    public Mono<Response<Integer>> getChatMemberCount(@NotNull Long chatId) {
        return client.getChatMemberCount(String.valueOf(chatId));
    }

    @Override
    public Mono<Response<Integer>> getChatMemberCount(@NotNull String chatId) {
        return client.getChatMemberCount(chatId);
    }

    @Override
    public <T extends ChatMember> Mono<Response<T>> getChatMember(
            @NotNull Long chatId, @NotNull Long userId) {
        return client.getChatMember(String.valueOf(chatId), userId);
    }

    @Override
    public <T extends ChatMember> Mono<Response<T>> getChatMember(
            @NotNull String chatId, @NotNull Long userId) {
        return client.getChatMember(chatId, userId);
    }

    @Override
    public SendMessage sendMessage(@NotNull Long chatId) {
        return new SendMessage(String.valueOf(chatId), client);
    }

    @Override
    public SendMessage sendMessage(@NotNull String chatTag) {
        return new SendMessage(chatTag, client);
    }

    @Override
    public SendMessage sendMessage(@NotNull Chat chat) {
        Objects.requireNonNull(chat, "Chat" + VALUE_MUST_BE_NOT_NULL);
        return new SendMessage(String.valueOf(chat.getId()), client);
    }

    @Override
    public Mono<Response<Message>> sendMessage(@NotNull Long chatId, @NotNull String text) {
        return new SendMessage(String.valueOf(chatId), client).text(text).send();
    }

    @Override
    public Mono<Response<Message>> sendMessage(@NotNull Chat chat, @NotNull String text) {
        return sendMessage(chat).text(text).send();
    }

    @Override
    public SetMessageReaction setMessageReaction(@NotNull String chatId, @NotNull Long messageId) {
        return new SetMessageReaction(client, chatId, messageId);
    }

    @Override
    public SetMessageReaction setMessageReaction(@NotNull Long chatId, @NotNull Long messageId) {
        return new SetMessageReaction(client, chatId, messageId);
    }

    @Override
    public SetMessageReaction setMessageReaction(@NotNull Chat chat, @NotNull Message message) {
        return new SetMessageReaction(client, chat.getId(), message.getMessageId());
    }

    @Override
    public Mono<Response<Boolean>> dropMessageReaction(
            @NotNull String chatId, @NotNull Long messageId) {
        return new SetMessageReaction(client, chatId, messageId).send();
    }

    @Override
    public SendDocument sendDocument(@NotNull Long chatId) {
        return new SendDocument(String.valueOf(chatId), client);
    }

    @Override
    public SendDocument sendDocument(@NotNull String chatTag) {
        return new SendDocument(chatTag, client);
    }

    @Override
    public SendPhoto sendPhoto(@NotNull Long chatId) {
        return new SendPhoto(String.valueOf(chatId), client);
    }

    @Override
    public SendPhoto sendPhoto(@NotNull String chatTag) {
        return new SendPhoto(chatTag, client);
    }

    @Override
    public SendAnimation sendAnimation(@NotNull Long chatId) {
        return new SendAnimation(String.valueOf(chatId), client);
    }

    @Override
    public SendAnimation sendAnimation(@NotNull String chatTag) {
        return new SendAnimation(chatTag, client);
    }

    @Override
    public ForwardMessage forwardMessage(@NotNull String chatId, @NotNull Message message) {
        return new ForwardMessage(chatId, message, client);
    }

    @Override
    public ForwardMessage forwardMessage(
            @NotNull String chatId, @NotNull Long fromChatId, @NotNull Long messageId) {
        return new ForwardMessage(chatId, fromChatId, messageId, client);
    }

    @Override
    public CopyMessage copyMessage(@NotNull Chat chat, @NotNull Message message) {
        return new CopyMessage(
                String.valueOf(chat.getId()),
                String.valueOf(message.getChat().getId()),
                message.getMessageId(),
                client);
    }

    @Override
    public CopyMessage copyMessage(@NotNull String chatId, @NotNull Message message) {
        return new CopyMessage(
                chatId, String.valueOf(message.getChat().getId()), message.getMessageId(), client);
    }

    @Override
    public CopyMessage copyMessage(
            @NotNull String chatId, @NotNull String fromChatId, @NotNull Long messageId) {
        return new CopyMessage(chatId, fromChatId, messageId, client);
    }

    @Override
    public EditMessageText editMessageText(@NotNull Long chatId, @NotNull Long messageId) {
        return new EditMessageText(String.valueOf(chatId), String.valueOf(messageId), client);
    }

    @Override
    public EditMessageText editMessageText(@NotNull Message message) {
        return new EditMessageText(
                String.valueOf(message.getChat().getId()), String.valueOf(message.getMessageId()), client);
    }

    @Override
    public EditMessageReplyMarkup editMessageReplyMarkup(
            @NotNull Long chatId, @NotNull Long messageId) {
        return new EditMessageReplyMarkup(String.valueOf(chatId), String.valueOf(messageId), client);
    }

    @Override
    public EditMessageReplyMarkup editMessageReplyMarkup(@NotNull Message message) {
        return new EditMessageReplyMarkup(
                String.valueOf(message.getChat().getId()), String.valueOf(message.getMessageId()), client);
    }

    @Override
    public AnswerCallbackQuery answerCallbackQuery(@NotNull String callbackQueryId) {
        return new AnswerCallbackQuery(callbackQueryId, client);
    }

    @Override
    public Mono<Response<Boolean>> answerCallbackQuery(@NotNull String callbackQueryId, String text) {
        return new AnswerCallbackQuery(callbackQueryId, client).text(text).send();
    }

    @Override
    public AnswerCallbackQuery answerCallbackQuery(CallbackQuery callbackQuery) {
        return new AnswerCallbackQuery(callbackQuery.getId(), client);
    }

    @Override
    public Mono<Response<Boolean>> answerCallbackQuery(CallbackQuery callbackQuery, String text) {
        return new AnswerCallbackQuery(callbackQuery.getId(), client).text(text).send();
    }

    @Override
    public Mono<Response<Boolean>> deleteMessage(@NotNull Long chatId, @NotNull Long messageId) {
        return client.deleteMessage(chatId, messageId);
    }

    @Override
    public Mono<Response<List<BotCommand>>> send(
            @NotNull com.motokyi.tg.bot_api.api.method.payload.GetMyCommands getCommandsPayload) {
        Objects.requireNonNull(getCommandsPayload, "GetMyCommands" + VALUE_MUST_BE_NOT_NULL);
        return client.send(getCommandsPayload);
    }

    @Override
    public GetMyCommands getMyCommands() {
        return new GetMyCommands(client);
    }

    @Override
    public Mono<Response<List<BotCommand>>> getMyCommands(BotCommandScope scope) {
        return new GetMyCommands(client).scope(scope).send();
    }

    @Override
    public Mono<Response<List<BotCommand>>> getMyCommands(
            BotCommandScope scope, String languageCode) {
        return new GetMyCommands(client).scope(scope).languageCode(languageCode).send();
    }

    @Override
    public Mono<Response<Boolean>> send(
            @NotNull com.motokyi.tg.bot_api.api.method.payload.SetMyCommands commandsPayload) {
        Objects.requireNonNull(commandsPayload, "SetMyCommands" + VALUE_MUST_BE_NOT_NULL);
        return client.send(commandsPayload);
    }

    @Override
    public SetMyCommands setMyCommands() {
        return new SetMyCommands(client);
    }

    @Override
    public Mono<Response<Boolean>> send(
            @NotNull com.motokyi.tg.bot_api.api.method.payload.DeleteMyCommands deleteCommandsPayload) {
        Objects.requireNonNull(deleteCommandsPayload, "DeleteMyCommands" + VALUE_MUST_BE_NOT_NULL);
        return client.send(deleteCommandsPayload);
    }

    @Override
    public DeleteMyCommands deleteMyCommands() {
        return new DeleteMyCommands(client);
    }

    @Override
    public Mono<Response<Boolean>> deleteMyCommands(BotCommandScope scope) {

        return new DeleteMyCommands(client).scope(scope).send();
    }

    @Override
    public Mono<Response<Boolean>> deleteMyCommands(BotCommandScope scope, String languageCode) {
        return new DeleteMyCommands(client).scope(scope).languageCode(languageCode).send();
    }

    @Override
    public SetWebhook setWebhook(@NotNull String url) {
        return new SetWebhook(client, url);
    }

    @Override
    public DeleteWebhook deleteWebhook() {
        return new DeleteWebhook(client);
    }

    @Override
    public Mono<Response<WebhookInfo>> getWebhookInfo() {
        return client.getWebhookInfo();
    }
}
