package com.motokyi.tg.bot_api.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkdownV2MessageBuilderTest {

    private static final String EXPECTED_TEXT = """
            *bold \\*text*
            _italic \\*text_
            __underline__
            ~strikethrough~
            ||spoiler||
            *bold _italic bold ~italic bold strikethrough ||italic bold strikethrough spoiler||~ __underline italic bold___ bold*
            [inline URL](http://www.example.com/)
            [inline mention of a user](tg://user?id=123456789)
            ![👍](tg://emoji?id=5368324170671202286)
            `inline fixed-width code`
            ```
            pre-formatted fixed-width code block
            ```
            ```python
            pre-formatted fixed-width code block written in the Python programming language
            ```
            >Block quotation started
            >Block quotation continued
            >Block quotation continued
            >Block quotation continued
            >The last line of the block quotation
            **>The expandable block quotation started right after the previous block quotation
            >It is separated from the previous block quotation by an empty bold entity
            >Expandable block quotation continued
            >Hidden by default part of the expandable block quotation started
            >Expandable block quotation continued
            >The last line of the expandable block quotation with the expandability mark||
            """;

    @Test
    void test() {
        MarkdownV2MessageBuilder mb = MarkdownV2MessageBuilder.builder();
        //todo need to figure out where escaping needed via api
        mb.boldEsc("bold *text").newLine()
                .italicEsc("italic *text").newLine()
                .underline("underline").newLine()
                .strikethrough("strikethrough").newLine()
                .spoiler("spoiler").newLine()
                // implement wrapping or not?
                .text("*bold _italic bold ~italic bold strikethrough ||italic bold strikethrough spoiler||~ __underline italic bold___ bold*").newLine()
                .url("inline URL" , "http://www.example.com/").newLine()
                .mention("inline mention of a user" , 123456789).newLine()
                .emoji("👍" , 5368324170671202286L).newLine()
                .codeInline("inline fixed-width code").newLine()
                .codeBlock("pre-formatted fixed-width code block").newLine()
                .codeBlock("python","pre-formatted fixed-width code block written in the Python programming language").newLine()
                .quotation("Block quotation started").newLine()
                .quotation("Block quotation continued").newLine()
                .quotation("Block quotation continued").newLine()
                .quotation("Block quotation continued").newLine()
                .quotation("The last line of the block quotation").newLine()
                .quotationExpandableStart("The expandable block quotation started right after the previous block quotation").newLine()
                .quotation("It is separated from the previous block quotation by an empty bold entity").newLine()
                .quotation("Expandable block quotation continued").newLine()
                .quotation("Hidden by default part of the expandable block quotation started").newLine()
                .quotation("Expandable block quotation continued").newLine()
                .quotationExpandableEnd("The last line of the expandable block quotation with the expandability mark").newLine();
        assertEquals(EXPECTED_TEXT, mb.build());
    }
}