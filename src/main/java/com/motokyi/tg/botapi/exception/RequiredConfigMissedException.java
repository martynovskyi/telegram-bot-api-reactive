package com.motokyi.tg.botapi.exception;

public class RequiredConfigMissedException extends RuntimeException {
    public RequiredConfigMissedException(String message) {
        super(message);
    }
}
