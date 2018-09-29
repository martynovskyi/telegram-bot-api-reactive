package com.motokyi.choiceness.telegram.api.types.markup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class KeyboardMarkup {
    public String value() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
