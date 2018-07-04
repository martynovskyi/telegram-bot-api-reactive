package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.
 * See <a href="Game">https://core.telegram.org/bots/api#game</a>
 * <p>
 * Field	        Type	                Description
 * title    	    String	                Title of the game
 * description	    String	                Description of the game
 * photo	        Array of PhotoSize	    Photo that will be displayed in the game message in chats.
 * text	            String	                Optional. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
 * text_entities	Array of MessageEntity	Optional. Special types that appear in text, such as usernames, URLs, bot commands, etc.
 * animation	    Animation	            Optional. Animation that will be displayed in the game message in chats. Upload via BotFather
 */
@Data
public class Game {

    private String title;

    private String description;

    @JsonProperty("photo")
    private List<PhotoSize> photos;

    private String text;

    @JsonProperty("text_entities")
    private List<MessageEntity> textEntities;

    private Animation animation;
}
