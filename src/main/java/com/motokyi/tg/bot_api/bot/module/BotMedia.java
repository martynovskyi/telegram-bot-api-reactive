package com.motokyi.tg.bot_api.bot.module;

import com.motokyi.tg.bot_api.api.method.SendAnimation;
import com.motokyi.tg.bot_api.api.method.SendDocument;
import com.motokyi.tg.bot_api.api.method.SendPhoto;
import org.jetbrains.annotations.NotNull;

/** Interface defines bot operations related to different media content */
public interface BotMedia {
    SendDocument sendDocument(@NotNull Long chatId);

    SendDocument sendDocument(@NotNull String chatTag);

    SendPhoto sendPhoto(@NotNull Long chatId);

    SendPhoto sendPhoto(@NotNull String chatTag);

    SendAnimation sendAnimation(@NotNull Long chatId);

    SendAnimation sendAnimation(@NotNull String chatTag);
}
