package com.karadak.junitfive.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyServiceTest {

    private static final List<String> VALID_MESSAGES = asList("message 1", "message 2");

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    @DisplayName("fail when wrong messages are provided")
    public void contains_message_AssertionError(String message) {
        assertFalse(VALID_MESSAGES.contains(message), "contains a valid message");
    }

    @ParameterizedTest
    @ValueSource(strings = {"message 1", "message 2"})
    @DisplayName("correct messages")
    public void contains_message_Correct(String message) {
        assertThat(VALID_MESSAGES.contains(message), is(true));
    }

    @Test
    @DisplayName("assert with All 3 test cases")
    public void contains_validMessages_assertAll_Correct() {
        assertAll(() -> assertNotEquals("not a valid message", VALID_MESSAGES.get(0)),
                () -> assertEquals("message 1", VALID_MESSAGES.get(0)),
                () -> assertEquals("message 2", VALID_MESSAGES.get(1)));
    }

    @Test
    @DisplayName("Fail to get a message when index is wrong")
    public void get_validMessage_ThrowException() throws Exception {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> VALID_MESSAGES.get(666));
    }

}
