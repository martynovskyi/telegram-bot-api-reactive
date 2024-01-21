package com.motokyi.tg.bot_api.api.type.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.user.User;
import lombok.Data;

/**
 * Represents an invite link for a chat.
 *
 * @version Bot API 7.0
 * @see <a href="https://core.telegram.org/bots/api#chatinvitelink">ChatInviteLink</a>
 */
@Data
public class ChatInviteLink {
    @JsonProperty(ApiProperties.INVITE_LINK)
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
    private Long expireDate;

    @JsonProperty("member_limit")
    private Integer memberLimit;

    @JsonProperty("pending_join_request_count")
    private Integer pendingJoinRequestCount;
}
