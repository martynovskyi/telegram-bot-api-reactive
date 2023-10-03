package com.motokyi.tg.bot_api.exception;

public class InvalidBotRequestException extends RuntimeException {
    public InvalidBotRequestException(String message) {
        super(message);
    }
}
