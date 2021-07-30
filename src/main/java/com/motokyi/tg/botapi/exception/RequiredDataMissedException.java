package com.motokyi.tg.botapi.exception;

public class RequiredDataMissedException extends RuntimeException {
    public RequiredDataMissedException(String message) {
        super(message);
    }
}
