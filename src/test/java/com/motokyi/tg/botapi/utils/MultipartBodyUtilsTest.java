package com.motokyi.tg.botapi.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultipartBodyUtilsTest {
    public static final String KEY = "key";
    public static final String VALUE = "value";

    @Test
    void insertString() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        MultipartBodyUtils.insertString(KEY, VALUE, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertEquals(VALUE, result.getFirst(KEY).getBody());
    }

    @Test
    void insertString_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        MultipartBodyUtils.insertString(null, VALUE, builder);
        MultipartBodyUtils.insertString(KEY, null, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertTrue(result.isEmpty());
    }

    @Test
    void insertObject() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        Object value = new Object();
        MultipartBodyUtils.insertObject(KEY, value, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertEquals(value, result.getFirst(KEY).getBody());
    }

    @Test
    void insertObject_empty() {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        MultipartBodyUtils.insertObject(null, VALUE, builder);
        MultipartBodyUtils.insertObject(KEY, null, builder);
        MultiValueMap<String, HttpEntity<?>> result = builder.build();
        assertTrue(result.isEmpty());
    }

}