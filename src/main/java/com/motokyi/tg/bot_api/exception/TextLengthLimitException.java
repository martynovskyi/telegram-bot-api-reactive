package com.motokyi.tg.bot_api.exception;

public class TextLengthLimitException extends RuntimeException {
    public TextLengthLimitException(String message) {
        super(message);
    }
}
