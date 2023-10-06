package com.motokyi.tg.bot_api.api.type.inline;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.Location;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat partner.
 * See <a href="ChosenInlineResult">https://core.telegram.org/bots/api#choseninlineresult</a>
 * <p>
 * Field	            Type        Description
 * result_id            String	    The unique identifier for the result that was chosen
 * from	                User        The user that chose the result
 * location	            Location	Optional. Sender location, only for bots that require user location
 * inline_message_id	String	    Optional. Identifier of the sent inline message. Available only if there is an inline keyboard attached to the message. Will be also received in callback queries and can be used to edit the message.
 * query	            String	    The query that was used to obtain the result
 * <p>
 * Note: It is necessary to enable inline feedback via @Botfather in order to receive these objects in updates.
 */
@Data
public class ChosenInlineResult {

    @JsonProperty("result_id")
    private String resultId;

    private User from;

    private Location location;

    @JsonProperty(ApiProperties.INLINE_MESSAGE_ID)
    private String inlineMessageId;

    private String query;


}
