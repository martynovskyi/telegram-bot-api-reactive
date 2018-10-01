package com.motokyi.tg.botapi.exception;

public class RequiredDataMissedTGException extends RuntimeException {
    public RequiredDataMissedTGException(String message) {
        super(message);
    }
}
