package com.motokyi.tg.bot_api.api.method.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Use this method to send general files. On success, the sent Message is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
 * See <a href="SendDocument">https://core.telegram.org/bots/api#senddocument</a>
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendDocument extends SendMethod {
    public static final String DOCUMENT_ID = "document";

    @JsonIgnore
    private File documentFile;

    @JsonProperty(DOCUMENT_ID)
    private String documentId;

    public SendDocument(String chatId) {
        super(chatId);
    }
}
