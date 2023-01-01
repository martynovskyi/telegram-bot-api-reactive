package com.motokyi.tg.bot_api.api.types.markup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class KeyboardMarkup {
    public String value() throws JsonProcessingException {
        // //todo motokyi 31.12.2022: fix this mapper creation
        return new ObjectMapper().writeValueAsString(this);
    }
}
