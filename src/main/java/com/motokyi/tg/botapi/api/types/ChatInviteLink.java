package com.motokyi.tg.botapi.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents an invite link for a chat.
 * See <a href="ChatInviteLink">https://core.telegram.org/bots/api#chatinvitelink</a>
 * <p>
 */
@Data
public class ChatInviteLink {
    @JsonProperty("invite_link")
    private String inviteLink;

    private User creator;

    @JsonProperty("is_primary")
    private Boolean isPrimary;

    @JsonProperty("is_revoked")
    private Boolean isRevoked;

    @JsonProperty("expire_date")
    private Integer expireDate;

    @JsonProperty("member_limit")
    private Integer memberLimit;
}
