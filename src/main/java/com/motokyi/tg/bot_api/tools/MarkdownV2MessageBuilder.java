package com.motokyi.tg.bot_api.tools;

import com.motokyi.tg.bot_api.api.MarkdownV2Utils;

public class MarkdownV2MessageBuilder {
    private static final String LINE_BREAK = System.lineSeparator();
    private static final String WHITESPACE = " ";
    private final StringBuilder sb;

    private MarkdownV2MessageBuilder() {
        this.sb = new StringBuilder();
    }

    private MarkdownV2MessageBuilder(StringBuilder sb) {
        this.sb = sb;
    }

    private MarkdownV2MessageBuilder(CharSequence cs) {
        this.sb = new StringBuilder(cs);
    }

    public static MarkdownV2MessageBuilder builder() {
        return new MarkdownV2MessageBuilder();
    }

    public static MarkdownV2MessageBuilder of(StringBuilder sb) {
        return new MarkdownV2MessageBuilder(sb);
    }

    public static MarkdownV2MessageBuilder of(CharSequence text) {
        return new MarkdownV2MessageBuilder(text);
    }

    public MarkdownV2MessageBuilder bold(CharSequence text) {
        MarkdownV2Utils.bold(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder boldEsc(CharSequence text) {
        MarkdownV2Utils.boldEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder italic(CharSequence text) {
        MarkdownV2Utils.italic(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder italicEsc(CharSequence text) {
        MarkdownV2Utils.italicEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder underline(CharSequence text) {
        MarkdownV2Utils.underline(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder underlineEsc(CharSequence text) {
        MarkdownV2Utils.underlineEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder strikethrough(CharSequence text) {
        MarkdownV2Utils.strikethrough(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder strikethroughEsc(CharSequence text) {
        MarkdownV2Utils.strikethroughEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder spoiler(CharSequence text) {
        MarkdownV2Utils.spoiler(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder spoilerEsc(CharSequence text) {
        MarkdownV2Utils.spoilerEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder codeInline(CharSequence text) {
        MarkdownV2Utils.code(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder codeInlineEsc(CharSequence text) {
        MarkdownV2Utils.codeEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder codeBlock(CharSequence text) {
        MarkdownV2Utils.codeBlock(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder codeBlockEsc(CharSequence text) {
        MarkdownV2Utils.codeBlockEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder codeBlock(CharSequence type, CharSequence text) {
        MarkdownV2Utils.codeBlock(sb, type, text);
        return this;
    }

    public MarkdownV2MessageBuilder codeBlockEsc(CharSequence type, CharSequence text) {
        MarkdownV2Utils.codeBlockEsc(sb, type, text);
        return this;
    }

    public MarkdownV2MessageBuilder quotation(CharSequence text) {
        MarkdownV2Utils.quotation(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder quotationEsc(CharSequence text) {
        MarkdownV2Utils.quotationEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder quotationExpandableStart(CharSequence text) {
        MarkdownV2Utils.quotationExpandableStart(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder quotationExpandableStartEsc(CharSequence text) {
        MarkdownV2Utils.quotationExpandableStartEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder quotationExpandableEnd(CharSequence text) {
        MarkdownV2Utils.quotationExpandableEnd(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder quotationExpandableEndEsc(CharSequence text) {
        MarkdownV2Utils.quotationExpandableStartEsc(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder newLine() {
        sb.append(LINE_BREAK);
        return this;
    }

    public MarkdownV2MessageBuilder newLine(int count) {
        sb.repeat(LINE_BREAK, count);
        return this;
    }

    public MarkdownV2MessageBuilder whitespace() {
        sb.append(WHITESPACE);
        return this;
    }

    public MarkdownV2MessageBuilder space(int count) {
        sb.repeat(WHITESPACE, count);
        return this;
    }

    public MarkdownV2MessageBuilder text(CharSequence text) {
        sb.append(text);
        return this;
    }

    public MarkdownV2MessageBuilder textEsc(CharSequence text) {
        MarkdownV2Utils.escape(sb, text);
        return this;
    }

    public MarkdownV2MessageBuilder textLine(CharSequence text) {
        sb.append(text).append(LINE_BREAK);
        return this;
    }

    public MarkdownV2MessageBuilder textLineEsc(CharSequence text) {
        MarkdownV2Utils.escape(sb, text).append(LINE_BREAK);
        return this;
    }

    public MarkdownV2MessageBuilder url(CharSequence text, CharSequence url) {
        MarkdownV2Utils.url(sb, text, url);
        return this;
    }

    public MarkdownV2MessageBuilder mention(CharSequence text, Number id) {
        MarkdownV2Utils.mention(sb, text, id);
        return this;
    }

    public MarkdownV2MessageBuilder emoji(CharSequence text, Number id) {
        MarkdownV2Utils.emoji(sb, text, id);
        return this;
    }

    public String build() {
        return sb.toString();
    }
}
