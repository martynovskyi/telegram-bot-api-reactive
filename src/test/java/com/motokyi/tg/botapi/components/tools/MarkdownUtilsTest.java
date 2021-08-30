package com.motokyi.tg.botapi.components.tools;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkdownUtilsTest {

    @ParameterizedTest
    @CsvSource({"+380771234567,\\+380771234567",
            "test_text,test\\_text",
            "dot.text,dot\\.text",
            "a.b_c+v*d,a\\.b\\_c\\+v\\*d",
            "[a](b),\\[a\\]\\(b\\)"})
    void testEscapeForMarkdownV2(String s, String expected) {
        assertEquals(expected, MarkdownUtils.escapeForMarkdownV2(s));
    }

}