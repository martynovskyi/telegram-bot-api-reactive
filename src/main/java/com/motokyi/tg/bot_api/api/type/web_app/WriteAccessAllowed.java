package com.motokyi.tg.bot_api.api.type.web_app;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a service message about a user allowing a bot to write messages after adding it to
 * the attachment menu, launching a Web App from a link, or accepting an explicit request
 * from a Web App sent by the method requestWriteAccess.
 * See <a href="WriteAccessAllowed">https://core.telegram.org/bots/api#writeaccessallowed</a>
 * <p>
 *
 * @version Bot API 6.9
 */
@Data
public class WriteAccessAllowed {

    @JsonProperty("from_request")
    private Boolean fromRequest;

    @JsonProperty("web_app_name")
    private String webAppName;

    @JsonProperty("from_attachment_menu")
    private Boolean fromAttachmentMenu;
}
