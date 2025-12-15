package Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void testToTitleCase_hello() {
        String input = "hello";
        String expResult = "Hello";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase_yiWang() {
        String input = "yi wang";
        String expResult = "Yi Wang";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase_YiWang() {
        String input = "Yi Wang";
        String expResult = "Yi Wang";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase_YIWANG() {
        String input = "YI WANG";
        String expResult = "Yi Wang";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase_computerScienceAndMath() {
        String input = "computer science and math";
        String expResult = "Computer Science And Math";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase_singleChar() {
        String input = "a";
        String expResult = "A";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase_null() {
        String input = null;
        String expResult = null;
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }

    @Test
    void testToTitleCase_emptyString() {
        String input = "";
        String expResult = "";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }
}
