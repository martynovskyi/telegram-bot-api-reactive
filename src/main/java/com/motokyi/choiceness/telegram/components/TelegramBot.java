package com.motokyi.choiceness.telegram.components;

import com.motokyi.choiceness.telegram.api.methods.SendAnimation;
import com.motokyi.choiceness.telegram.api.methods.SendDocument;
import com.motokyi.choiceness.telegram.api.methods.SendMessage;
import com.motokyi.choiceness.telegram.api.methods.SendPhoto;
import com.motokyi.choiceness.telegram.api.types.Chat;
import com.motokyi.choiceness.telegram.api.types.TLResponce;
import com.motokyi.choiceness.telegram.api.types.User;
import com.motokyi.choiceness.telegram.resttemplate.TelegramBotRT;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TelegramBot implements TGBot {
    private final TelegramBotRT rt;

    @Override
    public TLResponce<User> getMe() {
        return rt.getMe();
    }

    @Override
    public TLResponce<Chat> getChat(Long chatId) {
        return rt.getChat(chatId);
    }

    @Override
    public TLResponce<Chat> getChat(String chatTag) {
        return rt.getChat(chatTag);
    }

    @Override
    public SendMessage sendMessage(Long chatId) {
        return new SendMessage(chatId, rt);
    }

    @Override
    public SendMessage sendMessage(String chatTag) {
        return new SendMessage(chatTag, rt);
    }

    @Override
    public SendDocument sendDocument(Long chatId) {
        return new SendDocument(chatId, rt);
    }

    @Override
    public SendDocument sendDocument(String chatTag) {
        return new SendDocument(chatTag, rt);
    }

    @Override
    public SendPhoto sendPhoto(Long chatId) {
        return new SendPhoto(chatId, rt);
    }

    @Override
    public SendPhoto sendPhoto(String chatTag) {
        return new SendPhoto(chatTag, rt);
    }

    @Override
    public SendAnimation sendAnimation(Long chatId) {
        return new SendAnimation(chatId, rt);
    }

    @Override
    public SendAnimation sendAnimation(String chatTag) {
        return new SendAnimation(chatTag, rt);
    }
}
