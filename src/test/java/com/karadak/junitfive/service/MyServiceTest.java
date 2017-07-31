package com.karadak.junitfive.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyServiceTest {

    private static final List<String> VALID_MESSAGES = asList("message 1", "message 2");

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    @DisplayName("fail when wrong messages are provided")
    void contains_message_AssertionError(String message) {
        assertFalse(VALID_MESSAGES.contains(message), "contains a valid message");
    }

    @ParameterizedTest
    @ValueSource(strings = {"message 1", "message 2"})
    @DisplayName("correct messages")
    void contains_message_correct(String message) {
        assertThat(VALID_MESSAGES.contains(message), is(true));
    }
}
