package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TLResponce<T> {

    private boolean ok;

    private T result;

    @JsonProperty("error_code")
    private Integer errorCode;

    private String description;
}
