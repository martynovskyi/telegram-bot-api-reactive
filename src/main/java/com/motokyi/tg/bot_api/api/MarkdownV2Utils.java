package com.motokyi.tg.bot_api.api;

import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MarkdownV2Utils {
    // https://core.telegram.org/bots/api#markdownv2-style
    public static final String UNDERLINE_MD = "__";
    public static final String CODE_BLOCK_MD = "```";
    public static final String SPOILER_MD = "||";
    private static final char[] SPECIAL_CHARACTERS =
            new char[] {
                '_', '*', '[', ']', '(', ')', '~', '`', '>', '#', '+', '-', '=', '|', '{', '}', '.', '!'
            };
    private static final Set<Character> SPEC_CHARS_SET = new HashSet<>();

    static {
        for (char c : SPECIAL_CHARACTERS) {
            SPEC_CHARS_SET.add(c);
        }
    }

    public static StringBuilder escape(@NotNull StringBuilder sb, CharSequence text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (SPEC_CHARS_SET.contains(c)) {
                sb.append("\\");
            }
            sb.append(c);
        }
        return sb;
    }

    public static String escape(@NotNull CharSequence text) {
        return escape(new StringBuilder(), text).toString();
    }

    public static StringBuilder bold(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(SPECIAL_CHARACTERS[1]).append(text).append(SPECIAL_CHARACTERS[1]);
    }

    public static StringBuilder boldEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(SPECIAL_CHARACTERS[1]), text).append(SPECIAL_CHARACTERS[1]);
    }

    public static StringBuilder italic(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(SPECIAL_CHARACTERS[0]).append(text).append(SPECIAL_CHARACTERS[0]);
    }

    public static StringBuilder italicEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(SPECIAL_CHARACTERS[0]), text).append(SPECIAL_CHARACTERS[0]);
    }

    public static StringBuilder underline(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(UNDERLINE_MD).append(text).append(UNDERLINE_MD);
    }

    public static StringBuilder underlineEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(UNDERLINE_MD), text).append(UNDERLINE_MD);
    }

    public static StringBuilder strikethrough(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(SPECIAL_CHARACTERS[6]).append(text).append(SPECIAL_CHARACTERS[6]);
    }

    public static StringBuilder strikethroughEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(SPECIAL_CHARACTERS[6]), text).append(SPECIAL_CHARACTERS[6]);
    }

    public static StringBuilder spoiler(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(SPOILER_MD).append(text).append(SPOILER_MD);
    }

    public static StringBuilder spoilerEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(SPOILER_MD), text).append(SPOILER_MD);
    }

    public static StringBuilder quotation(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(SPECIAL_CHARACTERS[8]).append(text);
    }

    public static StringBuilder quotationEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(SPECIAL_CHARACTERS[8]), text);
    }

    public static StringBuilder quotationExpandableStart(
            @NotNull StringBuilder sb, CharSequence text) {
        return sb.append("**>").append(text);
    }

    public static StringBuilder quotationExpandableEnd(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(SPECIAL_CHARACTERS[8]).append(text).append(SPOILER_MD);
    }

    public static StringBuilder quotationExpandableStartEsc(
            @NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append("**>"), text);
    }

    public static StringBuilder quotationExpandableEndEsc(
            @NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(SPECIAL_CHARACTERS[8]), text).append(SPOILER_MD);
    }

    public static StringBuilder url(@NotNull StringBuilder sb, CharSequence text, CharSequence url) {
        return sb.append(SPECIAL_CHARACTERS[2])
                .append(text)
                .append("](")
                .append(url)
                .append(SPECIAL_CHARACTERS[5]);
    }

    public static StringBuilder mention(@NotNull StringBuilder sb, CharSequence text, Number id) {
        return sb.append(SPECIAL_CHARACTERS[2])
                .append(text)
                .append("](tg://user?id=")
                .append(id)
                .append(SPECIAL_CHARACTERS[5]);
    }

    public static StringBuilder emoji(@NotNull StringBuilder sb, CharSequence text, Number id) {
        return sb.append("![")
                .append(text)
                .append("](tg://emoji?id=")
                .append(id)
                .append(SPECIAL_CHARACTERS[5]);
    }

    public static StringBuilder code(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(SPECIAL_CHARACTERS[7]).append(text).append(SPECIAL_CHARACTERS[7]);
    }

    public static StringBuilder codeEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(SPECIAL_CHARACTERS[7]), text).append(SPECIAL_CHARACTERS[7]);
    }

    public static StringBuilder codeBlock(@NotNull StringBuilder sb, CharSequence text) {
        return sb.append(CODE_BLOCK_MD)
                .append(System.lineSeparator())
                .append(text)
                .append(System.lineSeparator())
                .append(CODE_BLOCK_MD);
    }

    public static StringBuilder codeBlockEsc(@NotNull StringBuilder sb, CharSequence text) {
        return escape(sb.append(CODE_BLOCK_MD).append(System.lineSeparator()), text)
                .append(System.lineSeparator())
                .append(CODE_BLOCK_MD);
    }

    public static StringBuilder codeBlock(
            @NotNull StringBuilder sb, CharSequence type, CharSequence text) {
        return sb.append(CODE_BLOCK_MD)
                .append(type)
                .append(System.lineSeparator())
                .append(text)
                .append(System.lineSeparator())
                .append(CODE_BLOCK_MD);
    }

    public static StringBuilder codeBlockEsc(
            @NotNull StringBuilder sb, CharSequence type, CharSequence text) {
        return escape(sb.append(CODE_BLOCK_MD).append(type).append(System.lineSeparator()), text)
                .append(System.lineSeparator())
                .append(CODE_BLOCK_MD);
    }
}
