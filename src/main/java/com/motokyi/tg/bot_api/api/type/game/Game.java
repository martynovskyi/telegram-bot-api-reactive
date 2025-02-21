package com.motokyi.tg.bot_api.api.type.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.media.Animation;
import com.motokyi.tg.bot_api.api.type.media.PhotoSize;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import lombok.Data;

import java.util.List;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#game">Game</a>
 */
@Data
public class Game {

    private String title;

    private String description;

    private List<PhotoSize> photo;

    private String text;

    @JsonProperty(ApiProperties.TEXT_ENTITIES)
    private List<MessageEntity> textEntities;

    private Animation animation;
}
