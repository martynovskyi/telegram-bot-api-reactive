package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents an invite link for a chat.
 * See <a href="ChatInviteLink">https://core.telegram.org/bots/api#chatinvitelink</a>
 * <p>
 * Bot API 6.4
 */
@Data
public class ChatInviteLink {
    @JsonProperty("invite_link")
    private String inviteLink;

    private User creator;

    @JsonProperty("creates_join_request")
    private Boolean createsJoinRequest;

    @JsonProperty("is_primary")
    private Boolean isPrimary;

    @JsonProperty("is_revoked")
    private Boolean isRevoked;

    private String name;

    @JsonProperty("expire_date")
    private Integer expireDate;

    @JsonProperty("member_limit")
    private Integer memberLimit;

    @JsonProperty("pending_join_request_count")
    private Integer pendingJoinRequestCount;
}
