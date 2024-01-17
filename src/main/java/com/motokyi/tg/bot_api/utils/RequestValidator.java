package com.motokyi.tg.bot_api.utils;

import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.exception.InvalidBotRequestException;
import com.motokyi.tg.bot_api.exception.TextLengthLimitException;
import org.apache.commons.lang3.StringUtils;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class RequestValidator {

    private RequestValidator() {
    }

    public static void stringLength(String value, String paramName, int min, int max) {
        if (min == 0 && StringUtils.isBlank(value)) {
            return;
        }
        if (isNull(value) || value.length() < min || value.length() > max) {
            throw new TextLengthLimitException("Property '%s' is out of range %d - %d".formatted(paramName, min, max));
        }
    }

    public static void languageCodeNullable(String value) {
        if (nonNull(value)) {
            stringLength(value, "language_code", 2, 2);
        }
    }

    public static void setMyName(String name, String languageCode) {
        if (StringUtils.isAllBlank(name, languageCode)) {
            throw new InvalidBotRequestException("Params 'name', 'language_code' are blank values");
        }
        if (StringUtils.isNotBlank(name)) {
            stringLength(name, ApiProperties.NAME, 0, 64);
        }
        languageCodeNullable(languageCode);
    }

    public static void setMyDescription(String description, String languageCode) {
        if (StringUtils.isAllBlank(description, languageCode)) {
            throw new InvalidBotRequestException("Params 'description' are 'language_code' are blank values");
        }
        if (StringUtils.isNotBlank(description)) {
            stringLength(description, ApiProperties.DESCRIPTION, 0, 512);
        }
        languageCodeNullable(languageCode);
    }

    public static void setMyShortDescription(String description, String languageCode) {
        if (StringUtils.isAllBlank(description, languageCode)) {
            throw new InvalidBotRequestException("Params 'short_description' and 'language_code' are blank values");
        }
        if (StringUtils.isNotBlank(description)) {
            stringLength(description, ApiProperties.SHORT_DESCRIPTION, 0, 120);
        }
        languageCodeNullable(languageCode);
    }
}
