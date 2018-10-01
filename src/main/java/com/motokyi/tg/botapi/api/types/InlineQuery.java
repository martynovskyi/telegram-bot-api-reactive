package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.
 * See <a href="InlineQuery">https://core.telegram.org/bots/api#inlinequery</a>
 * <p>
 * Field        Type	    Description
 * id	        String	    Unique identifier for this query
 * from	        User        Sender
 * location  	Location    Optional. Sender location, only for bots that request user location
 * query	    String	    Text of the query (up to 512 characters)
 * offset	    String	    Offset of the results to be returned, can be controlled by the bot
 */
@Data
@JsonInclude(NON_NULL)
public class InlineQuery {

    private String id;

    private User from;

    private Location location;

    private String query;

    private String offset;
}
