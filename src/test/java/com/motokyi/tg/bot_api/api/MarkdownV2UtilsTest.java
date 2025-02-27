package com.motokyi.tg.bot_api.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarkdownV2UtilsTest {

    @ParameterizedTest
    @CsvSource({
        "+380771234567,\\+380771234567",
        "test_text,test\\_text",
        "dot.text,dot\\.text",
        "a.b_c+v*d,a\\.b\\_c\\+v\\*d",
        "[a](b),\\[a\\]\\(b\\)"
    })
    void testEscape(String s, String expected) {
        assertEquals(expected, MarkdownV2Utils.escape(s));
    }

    @ParameterizedTest
    @CsvSource({
        "+380771234567,\\+380771234567",
        "test_text,test\\_text",
        "dot.text,dot\\.text",
        "a.b_c+v*d,a\\.b\\_c\\+v\\*d",
        "[a](b),\\[a\\]\\(b\\)"
    })
    void testEscape_withStringBuilder(String s, String expected) {
        assertEquals(expected, MarkdownV2Utils.escape(new StringBuilder(), s).toString());
    }

    @Test
    void testBold() {
        assertEquals("*bold*", MarkdownV2Utils.bold(new StringBuilder(), "bold").toString());
    }

    @Test
    void testBoldEscape() {
        assertEquals("*\\_bold*", MarkdownV2Utils.boldEsc(new StringBuilder(), "_bold").toString());
    }

    @Test
    void testItalic() {
        assertEquals("_italic_", MarkdownV2Utils.italic(new StringBuilder(), "italic").toString());
    }

    @Test
    void testItalicEscape() {
        assertEquals(
                "_\\*italic_", MarkdownV2Utils.italicEsc(new StringBuilder(), "*italic").toString());
    }

    @Test
    void testUnderline() {
        assertEquals(
                "__underline__", MarkdownV2Utils.underline(new StringBuilder(), "underline").toString());
    }

    @Test
    void testUnderlineEscape() {
        assertEquals(
                "__\\+underline__",
                MarkdownV2Utils.underlineEsc(new StringBuilder(), "+underline").toString());
    }

    @Test
    void testStrikethrough() {
        assertEquals(
                "~strikethrough~",
                MarkdownV2Utils.strikethrough(new StringBuilder(), "strikethrough").toString());
    }

    @Test
    void testStrikethroughEscape() {
        assertEquals(
                "~\\=strikethrough~",
                MarkdownV2Utils.strikethroughEsc(new StringBuilder(), "=strikethrough").toString());
    }

    @Test
    void testSpoiler() {
        assertEquals("||spoiler||", MarkdownV2Utils.spoiler(new StringBuilder(), "spoiler").toString());
    }

    @Test
    void testSpoilerEscape() {
        assertEquals(
                "||\\!spoiler||", MarkdownV2Utils.spoilerEsc(new StringBuilder(), "!spoiler").toString());
    }

    @Test
    void testQuotation() {
        assertEquals(
                ">quotation", MarkdownV2Utils.quotation(new StringBuilder(), "quotation").toString());
    }

    @Test
    void testQuotationEscape() {
        assertEquals(
                ">quotation\\.",
                MarkdownV2Utils.quotationEsc(new StringBuilder(), "quotation.").toString());
    }

    @Test
    void testQuotationExpandableStart() {
        assertEquals(
                "**>quotation",
                MarkdownV2Utils.quotationExpandableStart(new StringBuilder(), "quotation").toString());
    }

    @Test
    void testQuotationExpandableStartEscape() {
        assertEquals(
                "**>quotation\\.",
                MarkdownV2Utils.quotationExpandableStartEsc(new StringBuilder(), "quotation.").toString());
    }

    @Test
    void testQuotationExpandableEnd() {
        assertEquals(
                ">quotation||",
                MarkdownV2Utils.quotationExpandableEnd(new StringBuilder(), "quotation").toString());
    }

    @Test
    void testQuotationExpandableEndEscape() {
        assertEquals(
                ">quotation\\.||",
                MarkdownV2Utils.quotationExpandableEndEsc(new StringBuilder(), "quotation.").toString());
    }

    @Test
    void testUrl() {
        assertEquals(
                "[text](http://www.example.com/)",
                MarkdownV2Utils.url(new StringBuilder(), "text", "http://www.example.com/").toString());
    }

    @Test
    void testMention() {
        assertEquals(
                "[user](tg://user?id=12345)",
                MarkdownV2Utils.mention(new StringBuilder(), "user", 12345).toString());
    }

    @Test
    void testEmoji() {
        assertEquals(
                "![\uD83D\uDC4D](tg://emoji?id=12345)",
                MarkdownV2Utils.emoji(new StringBuilder(), "\uD83D\uDC4D", 12345).toString());
    }

    @Test
    void testCode() {
        assertEquals("`code`", MarkdownV2Utils.code(new StringBuilder(), "code").toString());
    }

    @Test
    void testCodeEscape() {
        assertEquals("`\\[code\\]`", MarkdownV2Utils.codeEsc(new StringBuilder(), "[code]").toString());
    }

    @Test
    void testCodeBlock() {
        assertEquals(
                "```\nblock\n```", MarkdownV2Utils.codeBlock(new StringBuilder(), "block").toString());
    }

    @Test
    void testCodeBlockEscape() {
        assertEquals(
                "```\n\\{block\\}\n```",
                MarkdownV2Utils.codeBlockEsc(new StringBuilder(), "{block}").toString());
    }

    @Test
    void testCodeBlockType() {
        assertEquals(
                "```java\nblock\n```",
                MarkdownV2Utils.codeBlock(new StringBuilder(), "java", "block").toString());
    }

    @Test
    void testCodeBlockTypeEscape() {
        assertEquals(
                "```java\n\\{block\\}\n```",
                MarkdownV2Utils.codeBlockEsc(new StringBuilder(), "java", "{block}").toString());
    }
}
