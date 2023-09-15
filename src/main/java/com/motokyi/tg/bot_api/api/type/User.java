package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * This object represents a Telegram user or bot.
 * <p>
 * See <a href="User">https://core.telegram.org/bots/api#user</a>
 * <p>
 * Bot API 6.4
 */
@Data
public class User {

    private Long id;

    @JsonProperty("is_bot")
    private Boolean isBot;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("language_code")
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
