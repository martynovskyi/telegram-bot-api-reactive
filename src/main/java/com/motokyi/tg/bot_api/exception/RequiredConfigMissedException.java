package com.motokyi.tg.bot_api.exception;

/**
 * For unsatisfied bot configuration
 */
public class RequiredConfigMissedException extends RuntimeException {
    public RequiredConfigMissedException(String message) {
        super(message);
    }
}
