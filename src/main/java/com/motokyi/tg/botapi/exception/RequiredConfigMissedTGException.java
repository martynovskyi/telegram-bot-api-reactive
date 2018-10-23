package com.motokyi.tg.botapi.exception;

public class RequiredConfigMissedTGException extends RuntimeException {
    public RequiredConfigMissedTGException(String message) {
        super(message);
    }
}
