package com.motokyi.tg.bot_api.api.type.web_app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import lombok.Data;

/**
 * This object represents a service message about a user allowing a bot to write messages after adding it to
 * the attachment menu, launching a Web App from a link, or accepting an explicit request
 * from a Web App sent by the method requestWriteAccess.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#writeaccessallowed">WriteAccessAllowed</a>
 */
@Data
public class WriteAccessAllowed {

    @JsonProperty(ApiProperties.FROM_REQUEST)
    private Boolean fromRequest;

    @JsonProperty(ApiProperties.WEB_APP_NAME)
    private String webAppName;

    @JsonProperty(ApiProperties.FROM_ATTACHMENT_MENU)
    private Boolean fromAttachmentMenu;
}
