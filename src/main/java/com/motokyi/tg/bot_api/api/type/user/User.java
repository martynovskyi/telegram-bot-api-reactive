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
 * @version Bot API 6.9
 */
@Data
public class User {

    private Long id;

    @JsonProperty("is_bot")
    private Boolean isBot;

    @JsonProperty(ApiProperties.FIRST_NAME)
    private String firstName;

    @JsonProperty(ApiProperties.LAST_NAME)
    private String lastName;

    @JsonProperty("username")
    private String userName;

    @JsonProperty(ApiProperties.LANGUAGE_CODE)
    private String languageCode;

    @JsonProperty("is_premium")
    private Boolean isPremium;

    @JsonProperty("added_to_attachment_menu")
    private Boolean addedToAttachmentMenu;

    @JsonProperty("can_join_groups")
    private Boolean canJoinGroups;

    @JsonProperty("can_read_all_group_messages")
    private Boolean canReadAllGroupMessages;

    @JsonProperty("supports_inline_queries")
    private Boolean supportsInlineQueries;
}
