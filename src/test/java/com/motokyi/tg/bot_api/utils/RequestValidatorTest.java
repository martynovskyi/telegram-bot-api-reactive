package com.motokyi.tg.bot_api.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.motokyi.tg.bot_api.exception.TextLengthLimitException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class RequestValidatorTest {

    public static final String LANGUAGE_CODE = "uk";

    public static Stream<Arguments> setMyNameOrDescriptionValidArgs() {
        return Stream.of(
                Arguments.of("", LANGUAGE_CODE),
                Arguments.of(null, LANGUAGE_CODE),
                Arguments.of("Name", null),
                Arguments.of("Name Bot", LANGUAGE_CODE));
    }

    public static Stream<Arguments> setMyNameInvalidArgs() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(null, null),
                Arguments.of("Name", ""),
                Arguments.of("n".repeat(64), ""));
    }

    public static Stream<Arguments> setMyDescriptionInvalidArgs() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(null, null),
                Arguments.of("Description", ""),
                Arguments.of("d".repeat(512), ""));
    }

    public static Stream<Arguments> setMyShortDescriptionInvalidArgs() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(null, null),
                Arguments.of("Description", ""),
                Arguments.of("d".repeat(120), ""));
    }

    @ParameterizedTest
    @MethodSource("setMyNameOrDescriptionValidArgs")
    void setMyName(String name, String languageCode) {
        assertDoesNotThrow(() -> RequestValidator.setMyName(name, languageCode));
    }

    @ParameterizedTest
    @MethodSource("setMyNameInvalidArgs")
    void setMyName_invalid(String name, String languageCode) {
        assertThrows(RuntimeException.class, () -> RequestValidator.setMyName(name, languageCode));
    }

    @ParameterizedTest
    @MethodSource("setMyNameOrDescriptionValidArgs")
    void setMyDescription(String name, String languageCode) {
        assertDoesNotThrow(() -> RequestValidator.setMyDescription(name, languageCode));
    }

    @ParameterizedTest
    @MethodSource("setMyDescriptionInvalidArgs")
    void setMyDescription_invalid(String description, String languageCode) {
        assertThrows(
                RuntimeException.class, () -> RequestValidator.setMyDescription(description, languageCode));
    }

    @ParameterizedTest
    @MethodSource("setMyNameOrDescriptionValidArgs")
    void setMyShortDescription(String name, String languageCode) {
        assertDoesNotThrow(() -> RequestValidator.setMyShortDescription(name, languageCode));
    }

    @ParameterizedTest
    @MethodSource("setMyShortDescriptionInvalidArgs")
    void setMyShortDescription_invalid(String description, String languageCode) {
        assertThrows(
                RuntimeException.class,
                () -> RequestValidator.setMyShortDescription(description, languageCode));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"1", "12345", "123", ""})
    void stringLength_valid(String str) {
        assertDoesNotThrow(() -> RequestValidator.stringLength(str, "str", 0, 5));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"123456", "aaaaaaaa10", ""})
    void stringLength_invalid(String str) {
        assertThrows(
                TextLengthLimitException.class, () -> RequestValidator.stringLength(str, "str", 1, 5));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"uk", "us"})
    void languageCodeNullable_valid(String languageCode) {
        RequestValidator.languageCodeNullable(languageCode);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ukr", "a", ""})
    void languageCodeNullable_invalid(String languageCode) {
        assertThrows(
                TextLengthLimitException.class, () -> RequestValidator.languageCodeNullable(languageCode));
    }
}
