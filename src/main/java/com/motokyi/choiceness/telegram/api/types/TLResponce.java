package com.motokyi.choiceness.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class TLResponce<T> {

    private boolean ok;

    private Optional<T> result;

    @JsonProperty("error_code")
    private Integer errorCode;

    private String description;
}
