package com.motokyi.tg.bot_api.exception;

public class RequiredDataMissedException extends RuntimeException {
    public RequiredDataMissedException(String message) {
        super(message);
    }
}
