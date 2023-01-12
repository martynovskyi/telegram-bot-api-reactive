package com.motokyi.tg.bot_api.api.type;

import lombok.Data;

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 * See <a href="User">https://core.telegram.org/bots/api#messageentity</a>
 * <p>
 * Field	Type	Description
 * type	    String	Type of the entity. Can be mention (@username), hashtag, bot_command, url, email, bold (bold text), italic (italic text), code (monowidth string), pre (monowidth block), text_link (for clickable text URLs), text_mention (for users without usernames)
 * offset	Integer	Offset in UTF-16 code units to the start of the entity
 * length	Integer	Length of the entity in UTF-16 code units
 * url	    String	Optional. For “text_link” only, url that will be opened after user taps on the text
 * user  	User	Optional. For “text_mention” only, the mentioned user
 */
@Data
public class MessageEntity {

    private String type;

    private Integer offset;

    private Integer length;

    private String url;

    private User user;

}
