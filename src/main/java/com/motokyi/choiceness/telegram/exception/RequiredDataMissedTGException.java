package com.motokyi.choiceness.telegram.exception;

public class RequiredDataMissedTGException extends RuntimeException {
    public RequiredDataMissedTGException(String message) {
        super(message);
    }
}
