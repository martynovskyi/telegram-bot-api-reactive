package com.motokyi.tg.bot_api.exception;

/**
 * For unsatisfied bot configuration
 */
public class MissedBotConfigException extends RuntimeException {
    public MissedBotConfigException(String message) {
        super(message);
    }
}
