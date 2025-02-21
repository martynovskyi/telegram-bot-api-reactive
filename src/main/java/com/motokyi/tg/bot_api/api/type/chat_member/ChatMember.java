package com.motokyi.tg.bot_api.api.type.chat_member;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.ChatMemberStatus;
import lombok.Data;

/**
 * This object contains information about one member of a chat.
 * <ul>Currently, the following 6 types of chat members are supported:
 * <li> ChatMemberOwner
 * <li> ChatMemberAdministrator
 * <li> ChatMemberMember
 * <li> ChatMemberRestricted
 * <li> ChatMemberLeft
 * <li> ChatMemberBanned
 * </ul>
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#chatmember">ChatMember</a>
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChatMemberOwner.class, name = ChatMemberStatus.CREATOR),
        @JsonSubTypes.Type(value = ChatMemberAdministrator.class, name = ChatMemberStatus.ADMINISTRATOR),
        @JsonSubTypes.Type(value = ChatMemberMember.class, name = ChatMemberStatus.MEMBER),
        @JsonSubTypes.Type(value = ChatMemberRestricted.class, name = ChatMemberStatus.RESTRICTED),
        @JsonSubTypes.Type(value = ChatMemberLeft.class, name = ChatMemberStatus.LEFT),
        @JsonSubTypes.Type(value = ChatMemberBanned.class, name = ChatMemberStatus.KICKED),
})
public class ChatMember {
    private String status;
}
