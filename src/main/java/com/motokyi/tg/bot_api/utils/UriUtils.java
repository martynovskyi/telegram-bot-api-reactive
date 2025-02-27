package com.motokyi.tg.bot_api.utils;

import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import java.net.URI;
import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.util.UriBuilder;

public final class UriUtils {
    private UriUtils() {}

    @NotNull
    public static Function<UriBuilder, URI> uriWithLanguageCode(String path, String languageCode) {
        return (uri) -> {
            uri.path(path);
            if (StringUtils.isNotBlank(languageCode)) {
                uri.queryParam(ApiProperties.LANGUAGE_CODE, languageCode);
            }
            return uri.build();
        };
    }

    public static void nonBlankParam(UriBuilder uri, String key, String value) {
        if (StringUtils.isNotBlank(value)) {
            uri.queryParam(key, value);
        }
    }
}
