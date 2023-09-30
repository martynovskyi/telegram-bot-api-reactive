package com.motokyi.tg.bot_api.api.type.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.type.media.Animation;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Data;

import java.util.List;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.
 * See <a href="Game">https://core.telegram.org/bots/api#game</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class Game {

    private String title;

    private String description;

    @JsonProperty("photo")
    private List<PhotoSize> photo;

    private String text;

    @JsonProperty("text_entities")
    private List<MessageEntity> textEntities;

    private Animation animation;
}
