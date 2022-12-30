package com.motokyi.tg.botapi.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.client.MultipartBodyBuilder;

import static java.util.Objects.nonNull;

public final class MultipartBodyUtils {
    public static void insertString(String key, String value, MultipartBodyBuilder builder) {
        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
            builder.part(key, value);
        }
    }

    public static void insertObject(String key, Object value, MultipartBodyBuilder builder) {
        if (StringUtils.isNotBlank(key) && nonNull(value)) {
            builder.part(key, value);
        }
    }

    private MultipartBodyUtils() {
    }
}
