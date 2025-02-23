package com.motokyi.tg.bot_api.api;

import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MarkdownUtils {
    // https://core.telegram.org/bots/api#markdownv2-style
    private static final Set<Character> SPEC_CHARS =
            Set.of(
                    '_', '*', '[', ']', '(', ')', '~', '`', '>', '#', '+', '-', '=', '|', '{', '}', '.', '!');

    public static String escapeForMarkdownV2(String s) {
        final StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (SPEC_CHARS.contains(c)) {
                sb.append('\\').append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
