package com.motokyi.tg.bot_api.api.type.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;


/**
 * This object represents a Telegram user or bot.
 * <p>
 * See <a href="User">https://core.telegram.org/bots/api#user</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class User {

    private Long id;

    @JsonProperty(ApiProperties.IS_BOT)
    private Boolean isBot;

    @JsonProperty(ApiProperties.FIRST_NAME)
    private String firstName;

    @JsonProperty(ApiProperties.LAST_NAME)
    private String lastName;

    @JsonProperty(ApiProperties.USERNAME)
    private String userName;

    @JsonProperty(ApiProperties.LANGUAGE_CODE)
    private String languageCode;

    @JsonProperty(ApiProperties.IS_PREMIUM)
    private Boolean isPremium;

    @JsonProperty(ApiProperties.ADDED_TO_ATTACHMENT_MENU)
    private Boolean addedToAttachmentMenu;

    @JsonProperty(ApiProperties.CAN_JOIN_GROUPS)
    private Boolean canJoinGroups;

    @JsonProperty(ApiProperties.CAN_READ_ALL_GROUP_MESSAGES)
    private Boolean canReadAllGroupMessages;

    @JsonProperty(ApiProperties.SUPPORTS_INLINE_QUERIES)
    private Boolean supportsInlineQueries;
}
