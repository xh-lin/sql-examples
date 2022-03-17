package com.teksystems.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestThisTest {

    private static TestThis testThis;

    @BeforeAll
    public static void setUp() {
        testThis = new TestThis();
    }

    @Test
    public void testGetNameAtIndexOne() {
        // given
        int input = 2;
        String expected = "Tony";

        testGetNameAtIndex(input, expected);
    }

    @Test
    public void testGetNameAtIndexTwo() {
        // given
        int input = 0;
        String expected = "Mike";

        testGetNameAtIndex(input, expected);
    }

    private void testGetNameAtIndex(int input, String expected) {
        // when
        String actual = testThis.getNameAtIndex(input);
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void testAddName() {
        // given
        String input = "Jared";
        String expected = input;
        // when
        testThis.addName(input);
        List<String> names = testThis.getNames();
        String actual = names.get(names.size() - 1);
        // then
        assertEquals(expected, actual);
    }

}
